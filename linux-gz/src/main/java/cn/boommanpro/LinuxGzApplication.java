package cn.boommanpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LinuxGzApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplication(LinuxGzApplication.class).run(args);
    }
}
