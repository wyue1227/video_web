package com.example.video_web.exception.token;

import com.example.video_web.exception.BaseException;

public class TokenCommonException extends BaseException {

    public TokenCommonException(TokenCommonErrorType error) {
        super(error, error.getMessage());
    }
}
