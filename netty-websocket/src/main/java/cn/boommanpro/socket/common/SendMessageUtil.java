package cn.boommanpro.socket.common;


import cn.boommanpro.socket.model.Message;
import cn.boommanpro.socket.model.MessageType;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendMessageUtil {
    public static void send(Channel channel, Message message) {
        channel.writeAndFlush(message);
    }

    public static void sendConnection(Channel channel,String deviceType) {
        Message message = new Message();
        message.setMessageType(MessageType.OPEN_CONNECTION);
        message.setData(deviceType.getBytes());
        channel.writeAndFlush(message);
    }
}
