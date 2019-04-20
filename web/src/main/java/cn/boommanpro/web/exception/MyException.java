package cn.boommanpro.web.exception;


import lombok.Data;

/**
 * @author Admin
 */
@Data
public class MyException extends RuntimeException {
    private static final long serialVersionUID = -3534408818282399865L;

    private String message;

    public MyException(String message ) {
        this.message = message;
    }
}
