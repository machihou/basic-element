package cn.boommanpro.cache.config.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.Map;

/**
 * @author 59232
 */
@Data
@ConfigurationProperties(prefix = "multi.cache.redis")
public class RedisCustomCacheProperties {

    /**
     * 缓存名，名称暗示了缓存时长 注意： 如果添加了新的缓存名，需要同时在下面的RedisCacheCustomizer#RedisCacheCustomizer里配置名称对应的缓存时长
     * ，时长为0代表永不过期；缓存名最好公司内部唯一，因为可能多个项目共用一个redis。
     */

    /**
     *
     */
    private Redis defaultCacheConfig;
    /**
     *
     */
    private Map<String, Redis> cacheNames;
    /**
     *
     */
    private Boolean allowInFlightCacheCreation;


    @Data
    public static class Redis {

        /**
         * Entry expiration. By default the entries never expire.
         */
        private Duration timeToLive;

        /**
         * Allow caching null values.
         */
        private boolean cacheNullValues = true;

        /**
         * Key prefix.
         */
        private String keyPrefix;

        /**
         * Whether to use the key prefix when writing to Redis.
         */
        private boolean useKeyPrefix = true;

        private RedisSerializationContext.SerializationPair<String> keySerializationPair;

        private RedisSerializationContext.SerializationPair<Object> valueSerializationPair;


        RedisCacheConfiguration determineConfiguration() {
            RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
            if (this.valueSerializationPair != null) {
                config = config.serializeValuesWith(valueSerializationPair);
            }
            if (this.keySerializationPair != null) {
                config = config.serializeKeysWith(keySerializationPair);
            }
            if (this.getTimeToLive() != null) {
                config = config.entryTtl(this.getTimeToLive());
            }
            if (this.getKeyPrefix() != null) {
                config = config.prefixKeysWith(this.getKeyPrefix());
            }
            if (!this.isCacheNullValues()) {
                config = config.disableCachingNullValues();
            }
            if (!this.isUseKeyPrefix()) {
                config = config.disableKeyPrefix();
            }
            return config;
        }
    }
}
