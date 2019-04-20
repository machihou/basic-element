package cn.boommanpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyWebSocketApplication {
    public static void main(String[] args) {
        new SpringApplication(NettyWebSocketApplication.class).run(args);
    }
}
