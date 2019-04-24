package cn.boommanpro.cache.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 通过此方法来控制 1.2级缓存
 */
@Configuration
@ConditionalOnProperty(name = "cache.use2L", havingValue = "false", matchIfMissing = true)
@EnableConfigurationProperties(RedisEhcacheProperties.class)
public class CacheConfig {

    @Autowired
    private RedisEhcacheProperties redisEhcacheProperties;

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory,RedisTemplate redisTemplate) {

        RedisCacheManager.RedisCacheManagerBuilder redisCacheManagerBuilder=RedisCacheManager
                .builder(redisConnectionFactory)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig());

//
//        Map<String, Long> expires = new HashMap<>(redisEhcacheProperties.getRedis().getExpires());
//        //毫秒->秒
//        expires.forEach((k, v) -> expires.put(k, v/1000));
//
//        rcm.setExpires(expires);
//        rcm.setDefaultExpiration(redisEhcacheProperties.getRedis().getDefaultExpiration());//默认过期时间
        return redisCacheManagerBuilder.build();
    }



}