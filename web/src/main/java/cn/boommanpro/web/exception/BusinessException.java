package cn.boommanpro.web.exception;

/**
 * @author Admin
 */
public class BusinessException extends MyException{
    private static final long serialVersionUID = 3134451052037167198L;

    public BusinessException(String message) {
        super(message);
    }
}
