package cn.boommanpro.cache.manager;

import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;
import org.springframework.data.redis.cache.RedisCache;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CustomRedisCacheManager extends AbstractTransactionSupportingCacheManager {



    @Override
    protected Collection<RedisCache> loadCaches() {
        List<RedisCache> caches = new LinkedList<>();

        return caches;
    }
}
