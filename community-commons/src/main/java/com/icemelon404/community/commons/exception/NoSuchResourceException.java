package com.icemelon404.community.commons.exception;

public class NoSuchResourceException extends BaseException {
    public NoSuchResourceException(String msg, Exception cause) {
        super(msg, cause);
    }
    public NoSuchResourceException(String msg) {
        super(msg);
    }
}
