package com.icemelon404.community.commons.exception;

public class BaseException extends RuntimeException {
    public BaseException(String msg, Exception cause) {
        super(msg, cause);
    }
    public BaseException(String msg) {
        super(msg);
    }
}
