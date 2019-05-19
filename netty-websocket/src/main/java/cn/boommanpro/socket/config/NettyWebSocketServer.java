package cn.boommanpro.socket.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author WebSocket
 */
@Component
public class NettyWebSocketServer {

    @Autowired
    private NettyWebSocketServerInitializer nettyWebSocketServerInitializer;

    private static   Integer nettyWebSocketPort;

    private static class SingletonWebSocketServer {
        static final NettyWebSocketServer instance = new NettyWebSocketServer();
    }

    public static NettyWebSocketServer getInstance() {
        return SingletonWebSocketServer.instance;
    }

    private EventLoopGroup mainGroup;
    private EventLoopGroup subGroup;
    private ServerBootstrap server;
    private ChannelFuture future;

    public NettyWebSocketServer() {
        mainGroup = new NioEventLoopGroup();
        subGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(mainGroup, subGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(nettyWebSocketServerInitializer);
    }

    public void start() throws UnknownHostException {
        this.future = server.bind(nettyWebSocketPort);

        String host = InetAddress.getLocalHost().getHostAddress();
        String path = "socket://" + host + ":" + nettyWebSocketPort;
        System.out.println("netty socket server 启动完毕...\n<------------------------------------------  " + path + "  ------------------------------------------>\n");
    }

    public static void setNettyWebSocketPort(Integer nettyWebSocketPort) {
        NettyWebSocketServer.nettyWebSocketPort = nettyWebSocketPort;
    }
}
