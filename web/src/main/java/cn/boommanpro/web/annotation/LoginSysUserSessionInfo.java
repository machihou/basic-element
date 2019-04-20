package cn.boommanpro.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 参数型注解，用于获取登录用户的uid
 * <p>
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME )
public @interface LoginSysUserSessionInfo {

}
