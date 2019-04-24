package cn.boommanpro.cache.custom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * 配置二级缓存
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableConfigurationProperties(RedisEhcacheProperties.class)
@ConditionalOnProperty(name = "cache.use2L", havingValue = "true", matchIfMissing = false)
public class CacheRedisEhcacheAutoConfiguration {

    @Autowired
    private RedisEhcacheProperties redisEhcacheProperties;

    @Bean
    public RedisEhcacheCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        return new RedisEhcacheCacheManager(redisEhcacheProperties, redisTemplate);
    }

    @Bean
    @ConditionalOnBean(RedisEhcacheCacheManager.class)
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisTemplate<Object, Object> redisTemplate,
                                                                       RedisEhcacheCacheManager redisEhcacheCacheManager) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisTemplate.getConnectionFactory());
        CacheMessageListener cacheMessageListener = new CacheMessageListener(redisTemplate, redisEhcacheCacheManager);
        redisMessageListenerContainer.addMessageListener(cacheMessageListener, new ChannelTopic(redisEhcacheProperties.getRedis().getTopic()));
        return redisMessageListenerContainer;
    }
}