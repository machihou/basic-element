package cn.boommanpro.generator.config;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 */
public enum ThymeLeafConfig {
    /**
     * Thymeleaf默认配置
     */
    INSTANCE;
    private TemplateEngine templateEngine;

    private static final String DEFAULT_PREFIX = "/templates/";

    ThymeLeafConfig() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix(DEFAULT_PREFIX);
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    public static TemplateEngine getTemplateEngine() {
        return INSTANCE.templateEngine;
    }
}
