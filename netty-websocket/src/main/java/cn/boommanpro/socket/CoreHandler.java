package cn.boommanpro.socket;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.ConcurrentSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author BoomMan
 * @Description: 处理消息的handler
 * TextWebSocketFrame： 在netty中，是用于为接受到的消息
 */
@Slf4j
@Component
public class CoreHandler extends ChannelInboundHandlerAdapter {

    public static final Set<Channel> channelSet = new ConcurrentSet<>();


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelSet.add(ctx.channel());
        log.error("新用户连接{},当前用户数{}", ctx.channel().id(), channelSet.size());

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel currentChannel = ctx.channel();
        channelSet.remove(currentChannel);
        log.error("用户移除{}", currentChannel.id());
        log.error("当前用户数量{}", channelSet.size());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        Channel currentChannel = ctx.channel();
        channelSet.remove(currentChannel);
        cause.printStackTrace();
        log.error("用户因为某种异常情况移除{} 异常信息{}", currentChannel.id(), cause.getMessage());
        log.error("当前用户数量{}", channelSet.size());
    }



}
