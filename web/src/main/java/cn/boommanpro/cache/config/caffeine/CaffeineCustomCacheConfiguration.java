package cn.boommanpro.cache.config.caffeine;

import cn.boommanpro.cache.CacheManagerNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * 创建方式参考 {@link org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration}
 */
@Configuration
@EnableCaching
@EnableConfigurationProperties({CaffeineCustomCacheProperties.class})
public class CaffeineCustomCacheConfiguration {
    /**
     * 创建基于Caffeine的Cache Manager
     *
     * 依照原方法是无法创建更加细粒度的 cacheName  -> CaffeineCache配置
     *
     * 如果需要都需要实现CacheManager接口来实现  可以参考 multi
     *
     */
    @Bean(CacheManagerNames.CAFFEINE_CACHE_MANAGER)
    @Primary
    public CaffeineCacheManager caffeineCacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        if (caffeineCustomCacheProperties.getSpecification() != null) {
            caffeineCacheManager.setCacheSpecification(caffeineCustomCacheProperties.getSpecification());
        }
        return caffeineCacheManager;

    }

    @Autowired
    private CaffeineCustomCacheProperties caffeineCustomCacheProperties;

}
