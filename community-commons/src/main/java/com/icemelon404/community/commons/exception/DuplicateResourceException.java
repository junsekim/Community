package com.icemelon404.community.commons.exception;

public class DuplicateResourceException extends BaseException{
    public DuplicateResourceException(String msg, Exception cause) {
        super(msg, cause);
    }
    public DuplicateResourceException(String msg) {
        super(msg);
    }
}
