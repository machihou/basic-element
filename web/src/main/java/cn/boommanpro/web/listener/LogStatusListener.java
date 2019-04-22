package cn.boommanpro.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Slf4j
@Component
@WebListener
public class LogStatusListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("新的会话建立");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("会话清除");
    }
}
