package cn.boommanpro.socket.model;

import io.protostuff.Tag;

public enum MessageType {
    /**
     * 信息类型美剧
     */
    @Tag(0)
    IMAGE("图片"),
    @Tag(1)
    VOICE("音频"),
    @Tag(2)
    OPEN_CONNECTION("建立发送连接,'发送视频和音频'"),
    @Tag(3)
    CLOSE_CONNECTION("关闭连接"),
    @Tag(4)
    XINGE_MESSAGE("信鸽信息"),
    @Tag(5)
    ACCEPT_REQUEST("接受视频通话请求"),
    @Tag(6)
    GROUP_VALID("群组有效"),
    @Tag(7)
    GROUP_INVALID("群组无效")
    ;

    private String description;

    MessageType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
