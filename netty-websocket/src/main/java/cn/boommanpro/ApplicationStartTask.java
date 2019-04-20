package cn.boommanpro;

import cn.boommanpro.socket.config.NettyWebSocketServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * @author BoomMan
 * @mail 592323211@qq.com
 * @date 2019/1/21 11:58
 * @description 系统启动任务
 */
@Component
public class ApplicationStartTask implements ApplicationRunner {

    @Value("${netty.socket.port}")
    private int port;





    @Override
    public void run(ApplicationArguments args) throws Exception {
        //启动netty
        NettyWebSocketServer.setNettyWebSocketPort(port);
        NettyWebSocketServer.getInstance().start();

    }



}
