package cn.boommanpro;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class ProxyUtils {
    /**
     * 获取 目标对象
     *
     * @param proxy 代理对象
     * @return
     * @throws Exception
     */
    public static Object getTarget(Object proxy) throws Exception {
        //不是代理对象
        if (!AopUtils.isAopProxy(proxy)) {
            return proxy;
        }

        if (AopUtils.isJdkDynamicProxy(proxy)) {
            return getJdkDynamicProxyTargetObject(proxy);
        } else { //cglib
            return getCglibProxyTargetObject(proxy);
        }
    }

    public static Type[] getTargetInterface(Object target){
        return target.getClass().getGenericInterfaces();
    }

    public static boolean isJdkDynamicProxy(Object proxy) {
        //不是代理对象
        if (!AopUtils.isAopProxy(proxy)) {
            return false;
        }
        return AopUtils.isJdkDynamicProxy(proxy);
    }

    public static boolean isCglibProxy(Object proxy) {
        //不是代理对象
        if (!AopUtils.isAopProxy(proxy)) {
            return false;
        }
        return !AopUtils.isJdkDynamicProxy(proxy);
    }




    private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        h.setAccessible(true);
        Object dynamicAdvisedInterceptor = h.get(proxy);
        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        return ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();
    }


    private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy) h.get(proxy);
        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        return ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();
    }


}
