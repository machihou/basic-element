package cn.boommanpro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    @RabbitListener
    public void processMessage(String content) {
        log.error("消费收到到消息:{}",content);
    }
}
