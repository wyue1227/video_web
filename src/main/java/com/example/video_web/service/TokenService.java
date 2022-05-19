package com.example.video_web.service;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.annotation.Resource;

import com.example.video_web.mapper.TokenMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.video_web.entity.po.Token;
import com.example.video_web.entity.status.TokenStatus;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TokenService {
    
    @Resource
    TokenMapper tokenMapper;

    /**
     * 添加校验用token
     * @param token
     * @return
     */
    @Transactional
    public String addNewToken(Integer userId) {
        Token token = new Token();
        token.setCreatedTime(LocalDateTime.now());
        token.setUpdatedTime(LocalDateTime.now());
        token.setCreatedBy(Token.DEFAULT_USERNAME);
        token.setUpdatedBy(Token.DEFAULT_USERNAME);
        token.setUserId(userId);
        token.setExpireTime(LocalDateTime.now().plusDays(7));
        tokenMapper.insert(token);
        return token.getTokenId();
    }

    /**
     * 获取Token详细内容
     * @param tokenId
     * @return
     */
    public Token getToken(String tokenId) {
        QueryWrapper<Token> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("token_id", tokenId);
        Token token = tokenMapper.selectOne(queryWrapper);
        return token;
    }

    /**
     * 校验Token
     */
    public TokenStatus checkToken(Token token) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expireTime = token.getExpireTime();

        // token不存在或过期
        if (token == null || now.isAfter(expireTime)) {
            return TokenStatus.EXPIRED;
        } else {
            Duration duration = Duration.between(now, expireTime);

            if (duration.toHours() < 24) {
                return TokenStatus.EXPIRING_SOON;
            } else {
                return TokenStatus.NOT_EXPIRED;
            }
        }
        
    }

    /**
     * // 过期时间小于24小时，延长过期时间
     * @param token
     * @return
     */
    @Transactional
    public Boolean delayExpireTime(Token token) {
        token.setExpireTime(token.getExpireTime().plusDays(7));
        token.setUpdatedBy(Token.DEFAULT_USERNAME);
        token.setUpdatedTime(LocalDateTime.now());
        return tokenMapper.updateById(token) > 0;
    }
}