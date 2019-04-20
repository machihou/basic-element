package cn.boommanpro.web;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author BoomMan
 * @mail 59232311@qq.com
 * @CreateTime 2018/11/17 10:18
 * @Version 1.0
 * @Description TODD
 */
@Configuration
public class HttpConvertConfiguration {
    /**
     * @author BoomMan
     * @mail 59232311@qq.com
     * @CreateTime 11:02 2018/11/1
     * @Version 1.0
     * @Description Web FastJSON返回配置
     **/
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1、需要先定义一个 convert 转换消息的对象;
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        fastJsonConfig.setSerializeFilters((ValueFilter) (o, s, source) -> {
            if (source == null) {
                return "";
            }
            if (source instanceof LocalDateTime) {
                return ((LocalDateTime) source).toInstant(ZoneOffset.of("+8")).toEpochMilli();
            }
            return source;
        });
        //3、在convert中添加配置信息.
        fastConverter.setFastJsonConfig(fastJsonConfig);

        //4、将convert添加到converters当中.
        return new HttpMessageConverters((HttpMessageConverter<?>) fastConverter);
    }
}
