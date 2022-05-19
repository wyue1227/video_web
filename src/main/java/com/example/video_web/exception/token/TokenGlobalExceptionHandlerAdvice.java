package com.example.video_web.exception.token;

import com.example.video_web.entity.vo.Result;
import com.example.video_web.exception.DefaultGlobalExceptionHandlerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TokenGlobalExceptionHandlerAdvice extends DefaultGlobalExceptionHandlerAdvice {

    @ExceptionHandler(value = {TokenCommonException.class})
    public Result tradeCommonException(TokenCommonException exception) {
        return Result.fail(exception.getErrorType());
    }

}
