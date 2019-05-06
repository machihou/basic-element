package cn.boommanpro;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class JdkProxyUtils {


    /**
     * 获取代理对象的interface信息
     */
    public static  Class<?>[] getTargetClassInterfaces(Object proxy) throws Exception {

        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy) h.get(proxy);

        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        AdvisedSupport advisedSupport = (AdvisedSupport) advised.get(aopProxy);
        return advisedSupport.getProxiedInterfaces();


    }
}
