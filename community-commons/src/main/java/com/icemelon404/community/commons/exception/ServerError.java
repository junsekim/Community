package com.icemelon404.community.commons.exception;

public class ServerError extends RuntimeException {
    public ServerError(String msg, Exception cause) {
        super(msg, cause);
    }
    public ServerError(String msg) {
        super(msg);
    }
}
