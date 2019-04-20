package cn.boommanpro.web.interceptor;


import cn.boommanpro.web.annotation.AllowNoLogin;
import cn.boommanpro.web.exception.NoAuthException;
import cn.boommanpro.web.exception.NotLoginException;
import cn.boommanpro.web.session.CurrentSessions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
@Slf4j
@Component
public class CheckPermissionInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!HandlerMethod.class.isAssignableFrom(handler.getClass())) {
            return true;
        }
        AllowNoLogin notLogin = AnnotationUtils.findAnnotation(((HandlerMethod) handler).getMethod(), AllowNoLogin.class);
        if (notLogin != null) {
            return true;
        }

        String url = request.getRequestURI();
        if (noPermission(url)) {
            log.error("访问url的地址为:{} 用户未登录Cookie:{},Session Id:{}", url, request.getCookies(), request.getSession().getId());
            throw new NoAuthException("未拥有权限");
        }
        return true;
    }

    /**
     * 判断是否登录 即判断是否存在 uid
     **/
    private boolean checkPermission(String url) {
        if (CurrentSessions.currentInfo() == null) {
            throw new NotLoginException();
        }
        return false;
    }

    private boolean noPermission(String url) {
        return !checkPermission(url);
    }
}
