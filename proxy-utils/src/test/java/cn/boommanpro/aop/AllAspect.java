package cn.boommanpro.aop;

import cn.boommanpro.ProxyUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AllAspect {

    @Pointcut(value = "execution(* cn.boommanpro.service..*.*(..))")
    public void pointcut() {
    }



    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object target = ProxyUtils.getTarget(joinPoint.getThis());

        return joinPoint.proceed();
    }
}
