package com.example.video_web.exception.token;

import com.example.video_web.exception.ErrorType;
import lombok.Getter;

@Getter
public enum TokenCommonErrorType implements ErrorType {

    TOKEN_DELAY("040100", "TOKEN过期！")
    ;

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String message;

    TokenCommonErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
