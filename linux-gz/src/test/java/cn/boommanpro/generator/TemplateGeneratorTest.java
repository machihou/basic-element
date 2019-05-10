package cn.boommanpro.generator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

@Slf4j
public class TemplateGeneratorTest {



    @Test
    public void generator() throws Exception {
        TemplateGenerator.generator("sxu-deu-class-room-search");

    }

    @Test
    public void doGenerator() {
        String generator = TemplateGenerator.doGenerator("sxu-deu-class-room-search", "Readme.md");
        System.out.println(generator.getBytes().length);
    }



    @Test
    public void printReadmeLength() {



        InputStream resourceAsStream = TemplateGeneratorTest.class.getResourceAsStream("templates/config/Readme.md");



        File file = new File("D:\\java_work_space\\basic-element\\linux-gz\\src\\main\\resources\\templates/config/Readme.md");
        System.out.println(file.length());

    }

}