package cn.boommanpro.generator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TemplateGeneratorTest {



    @Test
    public void generator() {
        TemplateGenerator.generator("sxu-deu-class-room-search");

    }

    @Test
    public void doGenerator() {
        String generator = TemplateGenerator.doGenerator("sxu-deu-class-room-search", "startup.sh");
        log.info(generator);
    }



}