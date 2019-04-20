package cn.boommanpro.web.exception;



/**
 * @author 用户未登录
 */
public class NoAuthException extends MyException {
    private static final long serialVersionUID = 8633878214653979318L;


    public NoAuthException(String message) {
        super(message);
    }
}
