package com.example.video_web.exception.user;

import com.example.video_web.entity.vo.Result;
import com.example.video_web.exception.DefaultGlobalExceptionHandlerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserGlobalExceptionHandlerAdvice extends DefaultGlobalExceptionHandlerAdvice {

    @ExceptionHandler(value = {UserCommonException.class})
    public Result tradeCommonException(UserCommonException exception) {
        return Result.fail(exception.getErrorType());
    }

}
