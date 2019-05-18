package cn.boommanpro.generator.config;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public enum ThymeLeafConfig {
    /**
     *
     */
    INSTANCE;
    private TemplateEngine templateEngine;

     ThymeLeafConfig(){
         ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix(getTemplatePath());
        templateResolver.setTemplateMode("TEXT");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    private String getTemplatePath(){
        return "/templates/";
    }

    public static TemplateEngine getTemplateEngine(){
        return INSTANCE.templateEngine;
    }
}
