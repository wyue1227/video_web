package com.example.video_web.exception;

import com.example.video_web.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@Slf4j
@RestControllerAdvice
public class DefaultGlobalExceptionHandlerAdvice {

    @ExceptionHandler(value = {BaseException.class})
    public Result baseException(BaseException ex) {
//        log.error("base exception:{}", ex.getMessage());
        return Result.fail(ex.getErrorType());
    }
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result exception(Exception ex) {
//        log.error("exception:{}", ex.getMessage());
        ex.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result throwable() {
        return Result.fail();
    }

}
