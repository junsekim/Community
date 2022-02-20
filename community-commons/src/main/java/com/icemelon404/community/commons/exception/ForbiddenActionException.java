package com.icemelon404.community.commons.exception;

public class ForbiddenActionException extends BaseException{
    public ForbiddenActionException(String msg, Exception cause) {
        super(msg, cause);
    }
    public ForbiddenActionException(String msg) {
        super(msg);
    }
}
