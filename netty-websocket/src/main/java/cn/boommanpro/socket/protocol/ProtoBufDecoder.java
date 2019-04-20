package cn.boommanpro.socket.protocol;


import cn.boommanpro.util.ProtoBufUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ProtoBufDecoder extends ByteToMessageDecoder {
    private Class<?> genericClass;

    public ProtoBufDecoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    public final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }

        in.markReaderIndex();
        int dataLength = in.readInt();
        if (dataLength < 0) {
            log.error("dataLength长度出错:{},ctxRemoteAddress信息:{}",dataLength,ctx.channel().remoteAddress());
            ctx.close();
        }
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
            return;
        }
        byte[] data = new byte[dataLength];
        in.readBytes(data);
        Object obj = ProtoBufUtil.deserializer(data, genericClass);
        out.add(obj);
    }
}
