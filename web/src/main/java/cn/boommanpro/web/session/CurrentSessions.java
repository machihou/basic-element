package cn.boommanpro.web.session;

import javax.servlet.http.HttpSession;

public class CurrentSessions {

    private static  final ThreadLocal<HttpSession> currentSession = new ThreadLocal<>();

    private static final String ACCOUNT_INFO = "sysUser-info";

    private CurrentSessions(){

    }

    public static void current(HttpSession httpSession) {
        currentSession.set(httpSession);
    }

    public static void cleanCurrent() {
        currentSession.remove();
    }


    public static HttpSession current() {
       return currentSession.get();
    }


    public static void currentAttr(String key, Object val) {
        HttpSession session = currentSession.get();
        if (session == null) {
            return;
        }
        session.setAttribute(key, val);
    }


    public static Object currentAttr(String key) {
        HttpSession session = currentSession.get();
        if (session == null) {
            return null;
        }
        return session.getAttribute(key);
    }

    public static void currentInfo(SysUserSession sysUserSession){
        currentAttr(ACCOUNT_INFO, sysUserSession);
    }
    public static SysUserSession currentInfo(){
      return (SysUserSession) currentAttr(ACCOUNT_INFO);
    }


    public static void clearAttr(){
        current().setAttribute(ACCOUNT_INFO, null);
    }
}
