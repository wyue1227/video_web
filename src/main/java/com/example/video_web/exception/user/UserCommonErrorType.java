package com.example.video_web.exception.user;

import com.example.video_web.exception.ErrorType;
import lombok.Getter;

@Getter
public enum UserCommonErrorType implements ErrorType {

    USER_NOT_FOUND("030100", "用户未找到！")
    ;

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String message;

    UserCommonErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
