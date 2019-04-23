package cn.boommanpro.cache;


import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Stephen.Shi
 * @summary CacheManager配置
 * @since 2018/9/9
 */
@Configuration
@EnableCaching
@EnableConfigurationProperties(CacheProperties.class)
public class CacheManagerConfig {
    private final CacheProperties cacheProperties;

    CacheManagerConfig(CacheProperties cacheProperties) {
        this.cacheProperties = cacheProperties;
    }

    /**
     * cacheManager名字
     */
    public interface CacheManagerNames {
        /**
         * redis
         */
        String REDIS_CACHE_MANAGER = "redisCacheManager";

        /**
         * ehCache
         */
        String EHCACHE_CACHE_MAANGER = "ehCacheCacheManager";
    }

    /**
     * 缓存名，名称暗示了缓存时长 注意： 如果添加了新的缓存名，需要同时在下面的RedisCacheCustomizer#RedisCacheCustomizer里配置名称对应的缓存时长
     * ，时长为0代表永不过期；缓存名最好公司内部唯一，因为可能多个项目共用一个redis。
     *
     */
    public interface CacheNames {
        /**
         * 15分钟缓存组
         */
        String CACHE_15MINS = "cp_salary:cache:15m";
        /**
         * 30分钟缓存组
         */
        String CACHE_30MINS = "cp_salary:cache:30m";
        /**
         * 60分钟缓存组
         */
        String CACHE_60MINS = "cp_salary:cache:60m";
        /**
         * 180分钟缓存组
         */
        String CACHE_180MINS = "cp_salary:cache:180m";
    }

    /**
     * ehcache缓存名
     */
    public interface EhCacheNames {
        String CACHE_15MINS = "cp_salary:cache:10m";

        String CACHE_20MINS = "cp_salary:cache:20m";

        String CACHE_30MINS = "cp_salary:cache:30m";
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 默认的redisCacheManager
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {

        RedisCacheManager.RedisCacheManagerBuilder redisCacheManagerBuilder=RedisCacheManager
				.builder(redisConnectionFactory)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig());
        return redisCacheManagerBuilder.build();

    }




    public static final int DEFAULT_MAXSIZE = 10000;
    public static final int DEFAULT_TTL = 600;

    /**
     * 定义cache名称、超时时长（秒）、最大容量
     * 每个cache缺省：10秒超时、最多缓存50000条数据，需要修改可以在构造方法的参数中指定。
     */
    public enum Caches {
        //有效期600秒
        getUserById(600),
        //有效期2个小时 , 最大容量1000
        listCustomers(7200, 1000),
        ;

        Caches() {
        }

        Caches(int ttl) {
            this.ttl = ttl;
        }

        Caches(int ttl, int maxSize) {
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        //最大數量
        private int maxSize = DEFAULT_MAXSIZE;
        //过期时间（秒）
        private int ttl = DEFAULT_TTL;

        public int getMaxSize() {
            return maxSize;
        }

        public int getTtl() {
            return ttl;
        }
    }

    /**
     * 创建基于Caffeine的Cache Manager
     *
     * @return
     */
    @Bean
    @Primary
    public CaffeineCacheManager caffeineCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();

        return cacheManager;
    }
}
