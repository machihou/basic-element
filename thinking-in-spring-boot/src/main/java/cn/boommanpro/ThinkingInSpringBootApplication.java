package cn.boommanpro;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThinkingInSpringBootApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplication(ThinkingInSpringBootApplication.class).run(args);
    }


}
