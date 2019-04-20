package cn.boommanpro.socket.common;

import io.netty.channel.Channel;

/**
 * @Auther: BoomMan
 * @Mail: 592323211@qq.com
 * @Date: 2019/1/22 16:12
 * @Description:
 */
public class ChannelUtil {
    public static String getChannelId(Channel channel) {
        return channel.id().asLongText();
    }
}
