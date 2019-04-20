package cn.boommanpro.socket.model;

import io.protostuff.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Message {
    @Tag(1)
    private MessageType messageType;
    @Tag(2)
    private byte[] data;

    public Message(MessageType messageType) {
        this.messageType = messageType;
    }
}
