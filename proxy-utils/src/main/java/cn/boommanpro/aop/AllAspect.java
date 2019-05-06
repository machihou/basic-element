package cn.boommanpro.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class AllAspect {

    @Pointcut(value = "execution(* cn.boommanpro.service.JdkService.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
}
