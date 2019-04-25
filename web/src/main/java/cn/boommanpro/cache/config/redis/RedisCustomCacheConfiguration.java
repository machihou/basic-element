package cn.boommanpro.cache.config.redis;

import cn.boommanpro.cache.CacheManagerNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 59232
 */
@Configuration
@EnableConfigurationProperties({RedisCustomCacheProperties.class})
public class RedisCustomCacheConfiguration {

    @Autowired
    private RedisCustomCacheProperties redisCustomCacheProperties;


    @Bean(CacheManagerNames.REDIS_CACHE_MANAGER)
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheManager.RedisCacheManagerBuilder redisCacheManagerBuilder = RedisCacheManager
                .builder(redisConnectionFactory)
                .withInitialCacheConfigurations(fromRedisCacheNamesGrouping(redisCustomCacheProperties.getCacheNames()));
        if (!redisCustomCacheProperties.getAllowInFlightCacheCreation()) {
            redisCacheManagerBuilder.disableCreateOnMissingCache();
        }
        return redisCacheManagerBuilder.build();

    }


    private Map<String, RedisCacheConfiguration> fromRedisCacheNamesGrouping(Map<String, RedisCustomCacheProperties.Redis> cacheNames) {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>(cacheNames.size());
        for (Map.Entry<String, RedisCustomCacheProperties.Redis> stringRedisEntry : cacheNames.entrySet()) {
            redisCacheConfigurationMap.put(stringRedisEntry.getKey(), stringRedisEntry.getValue().determineConfiguration());
        }
        return redisCacheConfigurationMap;
    }


}
