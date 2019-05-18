package cn.boommanpro.generator;

import cn.boommanpro.GzipUtil;
import cn.boommanpro.generator.config.ThymeLeafConfig;
import org.thymeleaf.context.Context;

import java.io.InputStream;

public class TemplateGenerator {

    private static final String JAR_FOLDER = "jar/";
    private static final String LOGS_FOLDER = "logs/";
    private static final String README_FILE = "Readme.md";
    private static final String STARTUP_FILE = "startup.sh";
    private static final String SHUTDOWN_FILE = "shutdown.sh";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    /**
     * 需要进行模板输出的是
     * <p>
     * 1.Readme.md
     * 2.shutdown.sh
     * 3.startup.sh
     * <p>
     * 然后将所有文件进行压缩
     */




    public static InputStream generator(String projectName) throws Exception {
        GeneratorFile[] generatorFiles = new GeneratorFile[]{
                GeneratorFile.of(JAR_FOLDER),
                GeneratorFile.of(LOGS_FOLDER),
                GeneratorFile.of(README_FILE).setContent(doGenerator(projectName, README_FILE)),
                GeneratorFile.of(STARTUP_FILE).setExecutable(true).setContent(doGenerator(projectName, STARTUP_FILE)),
                GeneratorFile.of(SHUTDOWN_FILE).setExecutable(true).setContent(doGenerator(projectName, SHUTDOWN_FILE)),
        };

        return  GzipUtil.pack(generatorFiles);


    }






    public static String doGenerator(String projectName, String fileName) {
        Context context = new Context();
        context.setVariable("projectName", projectName);
        context.setVariable("LEFT_BRACKET", LEFT_BRACKET);
        context.setVariable("RIGHT_BRACKET", RIGHT_BRACKET);
        return ThymeLeafConfig.getTemplateEngine().process("config/" + fileName, context);
    }

}
