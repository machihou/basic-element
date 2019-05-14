package cn.boommanpro.elasticsearch.bboss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ElasticsearchBbossApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplication(ElasticsearchBbossApplication.class).run(args);
    }
}
