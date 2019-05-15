package cn.boommanpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqimeng
 */
@RestController
@SpringBootApplication
public class RabbitmqApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplication(RabbitmqApplication.class).run(args);
    }

    @Autowired
    private Producer producer;

    @GetMapping
    public String send(){
        producer.send();
        return "发送成功";
    }
}
