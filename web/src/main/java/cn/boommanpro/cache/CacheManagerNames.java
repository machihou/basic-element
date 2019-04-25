package cn.boommanpro.cache;

/**
 * cacheManager名字
 */
public interface CacheManagerNames {
    /**
     * redis
     */
    String REDIS_CACHE_MANAGER = "redisCacheManager";

    /**
     * caffeine
     */
    String CAFFEINE_CACHE_MANAGER = "caffeineCacheManager";

    String REDIS_EHCACHE_CACHE_MANAGER = "redisEhcacheCacheManager";
}
