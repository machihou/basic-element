package cn.boommanpro.generator;

import cn.boommanpro.generator.config.ThymeLeafConfig;
import org.thymeleaf.context.Context;

public class TemplateGenerator {

    public static String generator(String projectName,String fileName){
        Context context = new Context();
        context.setVariable("projectName", projectName);
       return ThymeLeafConfig.getTemplateEngine().process("config/" + fileName, context);
    }
}
