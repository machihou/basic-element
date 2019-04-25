package cn.boommanpro.cache.config.multi;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.*;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
public class RedisEhcacheCacheManager implements CacheManager {

    private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();

    private RedisEhcacheProperties redisEhcacheProperties;

    private RedisTemplate<Object, Object> redisTemplate;

    private boolean dynamic = true;

    private Set<String> cacheNames;

    private org.ehcache.CacheManager ehCacheManager;
    private CacheConfiguration configuration;

    public RedisEhcacheCacheManager(RedisEhcacheProperties redisEhcacheProperties,
                                    RedisTemplate<Object, Object> redisTemplate) {
        super();
        this.redisEhcacheProperties = redisEhcacheProperties;
        this.redisTemplate = redisTemplate;
        this.dynamic = redisEhcacheProperties.isDynamic();
        this.cacheNames = redisEhcacheProperties.getCacheNames();
        setAboutEhCache();

    }
    private void setAboutEhCache(){
        long ehcacheExpire = redisEhcacheProperties.getEhcache().getExpireAfterWrite();
        this.configuration =
                CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(redisEhcacheProperties.getEhcache().getMaxEntry()))
                        .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcacheExpire)))
                        .build();
        this.ehCacheManager = CacheManagerBuilder
                .newCacheManagerBuilder()
                .build();
        this.ehCacheManager.init();
    }

    @Override
    public Cache getCache(String name) {
        Cache cache = cacheMap.get(name);
        if(cache != null) {
            return cache;
        }
        if(!dynamic && !cacheNames.contains(name)) {
            return cache;
        }

        cache = new RedisEhcacheCache(name, redisTemplate, getEhcache(name), redisEhcacheProperties);
        Cache oldCache = cacheMap.putIfAbsent(name, cache);
        log.debug("create cache instance, the cache name is : {}", name);
        return oldCache == null ? cache : oldCache;
    }

    public org.ehcache.Cache<Object, Object> getEhcache(String name){
        org.ehcache.Cache<Object, Object> res = ehCacheManager.getCache(name, Object.class, Object.class);
        if(res != null){
            return res;
        }

        return ehCacheManager.createCache(name, configuration);
    }

    @Override
    public Collection<String> getCacheNames() {
        return this.cacheNames;
    }

    public void clearLocal(String cacheName, Object key, Integer sender) {
        Cache cache = cacheMap.get(cacheName);
        if(cache == null) {
            return ;
        }

        RedisEhcacheCache redisEhcacheCache = (RedisEhcacheCache) cache;
        //如果是发送者本身发送的消息，就不进行key的清除
        if(redisEhcacheCache.getLocalCache().hashCode() != sender) {
            redisEhcacheCache.clearLocal(key);
        }
    }
}