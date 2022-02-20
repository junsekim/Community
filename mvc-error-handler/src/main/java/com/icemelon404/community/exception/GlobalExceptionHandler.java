package com.icemelon404.community.exception;

import com.icemelon404.community.commons.exception.BaseException;
import com.icemelon404.community.commons.exception.DuplicateResourceException;
import com.icemelon404.community.commons.exception.ForbiddenActionException;
import com.icemelon404.community.commons.exception.NoSuchResourceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ErrorResponse handle(DuplicateResourceException e) {
        log.warn("409 conflict: " + e);
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(ForbiddenActionException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody ErrorResponse handle(ForbiddenActionException e) {
        log.warn("403 forbidden: ", e);
        return new ErrorResponse(e.getMessage());
    }


    @ExceptionHandler(NoSuchResourceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handle(NoSuchResourceException e) {
        log.warn("404 not found: ", e);
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handle(BaseException e) {
        log.warn("확인되지 않은 비지니스 예외: ", e);
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorResponse handle(Exception e) {
        log.error("에러 발생: ", e);
        return new ErrorResponse(e.getMessage());
    }

}
