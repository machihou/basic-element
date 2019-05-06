package cn.boommanpro;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

public class AspectJUtils {

    /**
     * 根据ProceedingJoinPoint获取MethodName
     */
    public static String getMethodName(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        return method.getName();
    }

    /**
     * 获取方法
     */
    public static Method getMethod(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        return ms.getMethod();
    }


    /**
     * getThis 是代理类对象
     * getTarget 是原对象
     */


}
