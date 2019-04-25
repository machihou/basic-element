package cn.boommanpro;

import cn.boommanpro.cache.config.redis.RedisCustomCacheProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationStartTask implements CommandLineRunner {


    @Autowired
    private RedisCacheManager redisCacheManager;
    @Autowired
    private RedisCustomCacheProperties redisCustomCacheProperties;
    @Override
    public void run(String... args) throws Exception {
        log.info("{}",redisCacheManager);
    }
}
