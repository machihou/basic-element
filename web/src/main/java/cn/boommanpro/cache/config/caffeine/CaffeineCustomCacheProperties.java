package cn.boommanpro.cache.config.caffeine;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "multi.cache.caffeine")
public class CaffeineCustomCacheProperties {
    private String specification;
}
