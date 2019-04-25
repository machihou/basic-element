package cn.boommanpro.cache.config.multi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * 监听redis消息需要实现MessageListener接口
 * 利用本监听器来实现多redis同步缓存
 */
@Slf4j
public class CacheMessageListener implements MessageListener {

    private RedisTemplate<Object, Object> redisTemplate;

    private RedisEhcacheCacheManager redisEhcacheCacheManager;

    public CacheMessageListener(RedisTemplate<Object, Object> redisTemplate,
                                RedisEhcacheCacheManager redisEhcacheCacheManager) {
        super();
        this.redisTemplate = redisTemplate;
        this.redisEhcacheCacheManager = redisEhcacheCacheManager;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        CacheMessage cacheMessage = (CacheMessage) redisTemplate.getValueSerializer().deserialize(message.getBody());
        log.debug("recevice a redis topic message, clear local cache, the cacheName is {}, the key is {}", cacheMessage.getCacheName(), cacheMessage.getKey());
        redisEhcacheCacheManager.clearLocal(cacheMessage.getCacheName(), cacheMessage.getKey(), cacheMessage.getSender());
    }

}