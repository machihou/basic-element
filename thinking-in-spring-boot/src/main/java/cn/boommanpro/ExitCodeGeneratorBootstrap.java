package cn.boommanpro;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot 应用正常退出
 */
@EnableAutoConfiguration
public class ExitCodeGeneratorBootstrap {
    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
        System.out.println("ExitCodeGenerator Bean 创建");
        return ()->{
            System.out.println("执行退出码(88)生成...");
            return 88;
        };
    }

    public static void main(String[] args) {
        int exitCode = SpringApplication.exit(new SpringApplicationBuilder(ExitCodeGeneratorBootstrap.class).web(WebApplicationType.NONE).run(args));
        System.exit(exitCode);
    }
}
