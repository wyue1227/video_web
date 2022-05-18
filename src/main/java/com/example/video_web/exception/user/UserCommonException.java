package com.example.video_web.exception.user;

import com.example.video_web.exception.BaseException;

public class UserCommonException extends BaseException {

    public UserCommonException(UserCommonErrorType error) {
        super(error, error.getMessage());
    }
}
