package cn.boommanpro.generator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class TemplateGeneratorTest {

    @Test
    public void generator() {
        String generator = TemplateGenerator.generator("sxu-deu-class-room-search", "startup.sh");
        log.info(generator);
    }
}