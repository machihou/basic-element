package cn.boommanpro.common;

import lombok.Data;

/**
 * @author wangqimeng
 */
@Data
public class CallResult<T> {

    private String code;
    private T result;
    private String message;

    private CallResult(String code, T result, String message) {
        this.code = code;
        this.result = result;
        this.message = message;
    }

    public interface CodeEnum {
        String SUCCESS = "SUCCESS";
        String ERROR = "ERROR";
    }

    public static <T> CallResult<T> success() {
        return new CallResult<>(CodeEnum.SUCCESS, null, null);
    }

    public static <T> CallResult<T> success(T result) {
        return new CallResult<>(CodeEnum.SUCCESS, result, null);
    }

    public static <T> CallResult<T> error(String message) {
        return new CallResult<>(CodeEnum.ERROR, null, message);
    }
}
