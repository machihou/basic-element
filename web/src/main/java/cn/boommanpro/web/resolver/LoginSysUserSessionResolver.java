package cn.boommanpro.web.resolver;



import cn.boommanpro.web.annotation.LoginSysUserSessionInfo;
import cn.boommanpro.web.session.CurrentSessions;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author BoomMan
        * AccountSession参数注入
        */
public class LoginSysUserSessionResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LoginSysUserSessionInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return CurrentSessions.currentInfo();
    }
}
