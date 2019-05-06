package cn.boommanpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class CrawlerFruitApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = new SpringApplication(CrawlerFruitApplication.class).run();
    }
}
