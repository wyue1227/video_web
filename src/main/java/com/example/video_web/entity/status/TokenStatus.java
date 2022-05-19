package com.example.video_web.entity.status;

public enum TokenStatus {
    NOT_EXPIRED("未过期"),
    EXPIRING_SOON("即将过期"),
    EXPIRED("已过期")

    ;
    /**
     * 错误类型描述信息
     */
    private String message;

    TokenStatus(String message) {
        this.message = message;
    }
}