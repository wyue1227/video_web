package com.example.video_web.interceptor;

import com.example.video_web.entity.po.Token;
import com.example.video_web.entity.status.TokenStatus;
import com.example.video_web.exception.token.TokenCommonErrorType;
import com.example.video_web.exception.token.TokenCommonException;
import com.example.video_web.service.TokenService;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tokenId = request.getHeader("token");
        if (tokenId == null) {
            throw new TokenCommonException(TokenCommonErrorType.TOKEN_DELAY);
        }
        Token token = tokenService.getToken(tokenId);
        TokenStatus status = tokenService.checkToken(token);
        if (status == TokenStatus.EXPIRED) {
            throw new TokenCommonException(TokenCommonErrorType.TOKEN_DELAY);
        } else if (status == TokenStatus.EXPIRING_SOON) {
            tokenService.delayExpireTime(token);
        }
        return true;
    }
}
