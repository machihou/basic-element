package cn.boommanpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableScheduling
@EnableCaching
@EnableAsync
@SpringBootApplication
public class WebApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplication(WebApplication.class).run();

        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            TomcatServletWebServerFactory tomcatServletWebServerFactory = (TomcatServletWebServerFactory) context.getBean("tomcatServletWebServerFactory");
            int port = tomcatServletWebServerFactory.getPort();
            String contextPath = tomcatServletWebServerFactory.getContextPath();
            String path = "http://" + host + ":" + port + contextPath + "/";
            System.out.println("<------------------------------------------  " + path + "  ------------------------------------------>");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


}
