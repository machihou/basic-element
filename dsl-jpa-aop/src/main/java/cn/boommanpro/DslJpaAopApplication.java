package cn.boommanpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DslJpaAopApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = new SpringApplication(DslJpaAopApplication.class).run(args);
    }
}
