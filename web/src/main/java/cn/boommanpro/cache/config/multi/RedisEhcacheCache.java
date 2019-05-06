package cn.boommanpro.cache.config.multi;

import cn.boommanpro.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.springframework.cache.support.AbstractValueAdaptingCache;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * RedisEhcacheCache配置
 */
@Slf4j
public class RedisEhcacheCache extends AbstractValueAdaptingCache {

    private String name;

    private RedisTemplate<Object, Object> redisTemplate;

    private Cache<Object, Object> ehcacheCache;

    private String cachePrefix;

    private long defaultExpiration = 0;

    private Map<String, Long> expires;

    private String topic = "cache:redis:ehcache:topic";

    protected RedisEhcacheCache(boolean allowNullValues) {
        super(allowNullValues);
    }

    public RedisEhcacheCache(String name, RedisTemplate<Object, Object> redisTemplate, Cache<Object, Object> ehcacheCache, RedisEhcacheProperties redisEhcacheProperties) {
        super(redisEhcacheProperties.isCacheNullValues());
        this.name = name;
        this.redisTemplate = redisTemplate;
        this.ehcacheCache = ehcacheCache;
        this.cachePrefix = redisEhcacheProperties.getCachePrefix();
        this.defaultExpiration = redisEhcacheProperties.getRedis().getDefaultExpiration();
        this.expires = redisEhcacheProperties.getRedis().getExpires();
        this.topic = redisEhcacheProperties.getRedis().getTopic();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        Object value = lookup(key);
        if(value != null) {
            return (T) value;
        }

        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            value = lookup(key);
            if(value != null) {
                return (T) value;
            }
            value = valueLoader.call();
            Object storeValue = toStoreValue(valueLoader.call());
            put(key, storeValue);
            return (T) value;
        } catch (Exception e) {
            try {
                Class<?> c = Class.forName("org.springframework.cache.Cache$ValueRetrievalException");
                Constructor<?> constructor = c.getConstructor(Object.class, Callable.class, Throwable.class);
                RuntimeException exception = (RuntimeException) constructor.newInstance(key, valueLoader, e.getCause());
                throw exception;
            } catch (Exception e1) {
                throw new IllegalStateException(e1);
            }
        } finally {
            lock.unlock();
        }
    }

    //从持久层读取value，然后存入缓存。允许value = null
    @Override
    public void put(Object key, Object value) {
        if (!super.isAllowNullValues() && value == null) {
            this.evict(key);
            return;
        }
        long expire = getExpire();
        if(expire > 0) {
            redisTemplate.opsForValue().set(getKey(key), toStoreValue(value), expire, TimeUnit.MILLISECONDS);
        } else {
            redisTemplate.opsForValue().set(getKey(key), toStoreValue(value));
        }

        //通过redis推送消息，使其他服务的ehcache失效。
        //原来的有个缺点：服务1给缓存put完KV后推送给redis的消息，服务1本身也会接收到该消息，
        // 然后会将刚刚put的KV删除。这里把ehcacheCache的hashcode传过去，避免这个问题。
        push(new CacheMessage(this.name, key, this.ehcacheCache.hashCode()));

        ehcacheCache.put(key, value);
    }
    //key的生成    name:cachePrefix:key
    private Object getKey(Object key) {
        return this.name.concat(":").concat(StringUtils.isEmpty(cachePrefix) ? key.toString() : cachePrefix.concat(":").concat(key.toString()));
    }

    private long getExpire() {
        long expire = defaultExpiration;
        Long cacheNameExpire = expires.get(this.name);
        return cacheNameExpire == null ? expire : cacheNameExpire.longValue();
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        Object cacheKey = getKey(key);
        Object prevValue = null;
        // 考虑使用分布式锁，或者将redis的setIfAbsent改为原子性操作
        synchronized (key) {
            prevValue = redisTemplate.opsForValue().get(cacheKey);
            if(prevValue == null) {
                long expire = getExpire();
                if(expire > 0) {
                    redisTemplate.opsForValue().set(getKey(key), toStoreValue(value), expire, TimeUnit.MILLISECONDS);
                } else {
                    redisTemplate.opsForValue().set(getKey(key), toStoreValue(value));
                }

                push(new CacheMessage(this.name, key, this.ehcacheCache.hashCode()));

                ehcacheCache.put(key, toStoreValue(value));
            }
        }
        return toValueWrapper(prevValue);
    }

    @Override
    public void evict(Object key) {
        // 先清除redis中缓存数据，然后清除ehcache中的缓存，避免短时间内如果先清除ehcache缓存后其他请求会再从redis里加载到ehcache中
        redisTemplate.delete(getKey(key));

        push(new CacheMessage(this.name, key, this.ehcacheCache.hashCode()));

        ehcacheCache.remove(key);
    }

    @Override
    public void clear() {
        // 先清除redis中缓存数据，然后清除ehcache中的缓存，避免短时间内如果先清除ehcache缓存后其他请求会再从redis里加载到ehcache中
        Set<Object> keys = redisTemplate.keys(this.name.concat(":"));
        for(Object key : keys) {
            redisTemplate.delete(key);
        }

        push(new CacheMessage(this.name, null));

        ehcacheCache.clear();
    }

    //获根据key取缓存,如果返回null，则要读取持久层
    @Override
    protected Object lookup(Object key) {
        Object cacheKey = getKey(key);
        Object value = ehcacheCache.get(key);
        if(value != null) {
            log.debug("get cache from ehcache, the key is : {}", cacheKey);
            return value;
        }

        value = redisTemplate.opsForValue().get(cacheKey);

        if(value != null) {
            log.debug("get cache from redis and put in ehcache, the key is : {}", cacheKey);
            //将二级缓存重新复制到一级缓存。原理是最近访问的key很可能再次被访问
            ehcacheCache.put(key, value);
        }
        return value;
    }



    /**
     * 缓存变更时，利用redis的消息订阅功能，通知其他节点清理本地缓存。
     * @description
     * @param message
     */
    private void push(CacheMessage message) {

        redisTemplate.convertAndSend(topic, message);
    }

    /**
     * @description 清理本地缓存
     * @param key
     */
    public void clearLocal(Object key) {
        log.debug("clear local cache, the key is : {}", key);
        if(key == null) {
            ehcacheCache.clear();
        } else {
            ehcacheCache.remove(key);
        }
    }

    public Cache<Object, Object> getLocalCache(){
        return ehcacheCache;
    }
}
