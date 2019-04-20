package cn.boommanpro.socket.protocol;

import cn.boommanpro.socket.model.Message;
import cn.boommanpro.util.ProtoBufUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Admin
 */
public class ProtoBufEncoder extends MessageToByteEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        byte[] serializer = ProtoBufUtil.serializer(msg);
        out.writeInt(serializer.length);
        out.writeBytes(serializer);
    }
}
