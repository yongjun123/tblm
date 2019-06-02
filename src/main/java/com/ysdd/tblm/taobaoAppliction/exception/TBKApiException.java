package com.ysdd.tblm.taobaoAppliction.exception;

/**
 * 淘宝客api异常类
 */
public class TBKApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TBKApiException() {
        super();
    }

    public TBKApiException(String message) {
        super(message);
    }


    public TBKApiException(String message, Throwable cause) {
        super(message, cause);
    }


    public TBKApiException(Throwable cause) {
        super(cause);
    }
}
