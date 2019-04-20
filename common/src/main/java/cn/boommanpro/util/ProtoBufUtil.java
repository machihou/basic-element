package cn.boommanpro.util;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BoomMan
 *
 * 描述 Google Protocol Buffer Utils
 *
 * 对 List 和Map 进行简单封装 使用时用接口不要用实现类
 */
@Slf4j
@NoArgsConstructor
public class ProtoBufUtil {


    public static <T> byte[] serializer(T o) {
        if (o instanceof List || o instanceof Map) {
            @SuppressWarnings("unchecked")
            Schema<SerializerWrapper> schema = RuntimeSchema.getSchema(SerializerWrapper.class);
            return ProtobufIOUtil.toByteArray(new SerializerWrapper(o), schema, LinkedBuffer.allocate(LinkedBuffer.MIN_BUFFER_SIZE));
        }
        @SuppressWarnings("unchecked")
        Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(o.getClass());
        return ProtobufIOUtil.toByteArray(o, schema, LinkedBuffer.allocate(LinkedBuffer.MIN_BUFFER_SIZE));
    }

    public static <T> T deserializer(byte[] bytes, Class<T> clazz) {
        if (clazz==List.class  || clazz == Map.class) {
            Schema<SerializerWrapper> wrapperSchema = RuntimeSchema.getSchema(SerializerWrapper.class);
            SerializerWrapper wrapper = wrapperSchema.newMessage();
            ProtobufIOUtil.mergeFrom(bytes, wrapper, wrapperSchema);
            return (T) wrapper.getData();
        }
        Schema<T> schema = RuntimeSchema.getSchema(clazz);
        T obj = schema.newMessage();
        ProtobufIOUtil.mergeFrom(bytes, obj, schema);
        return obj;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class SerializerWrapper<T> {
        private T data;
    }

    public static void main(String[] args) {

        ArrayList<String> testList = new ArrayList<>();
        testList.add("123");
        testList.add("456");
        testList.add("789");
        testList.add("测试");
        byte[] serializer = ProtoBufUtil.serializer(testList);
        log.error("序列化结果: {}", serializer);
        List deserializer = ProtoBufUtil.deserializer(serializer, List.class);
        log.error("反序列化结果: {}", deserializer);
    }

}