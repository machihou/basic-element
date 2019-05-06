package cn.boommanpro;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class JdkProxyUtils {


    /**
     * 获取目标类 包装类的类型 Class.getName();
     */
    public static Class getTargetClassInterfaces(ProceedingJoinPoint joinPoint) throws Exception {

        Object proxy = joinPoint.getTarget();

        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy) h.get(proxy);

        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        AdvisedSupport advisedSupport = (AdvisedSupport) advised.get(aopProxy);

        Class<?>[] proxiedInterfaces = advisedSupport.getProxiedInterfaces();
        ParameterizedType genericInterface = ((ParameterizedType) proxiedInterfaces[0].getGenericInterfaces()[0]);

        return (Class) genericInterface.getActualTypeArguments()[0];

    }
}
