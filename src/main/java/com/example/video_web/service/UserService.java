package com.example.video_web.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.video_web.entity.po.User;
import com.example.video_web.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    // public boolean isExist(User user) {

    //     // 密码md5加密
    //     String password = DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes());

    //     QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    //     queryWrapper.eq("user_phone", user.getUserPhone());
    //     queryWrapper.eq("user_password", password);
    //     return userMapper.exists(queryWrapper);
    // }

    public User selectUser(User user) {
        // 密码md5加密
        String password = DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_phone", user.getUserPhone());
        queryWrapper.eq("user_password", password);
        return userMapper.selectOne(queryWrapper);
    }

    public Boolean addUser(User user) {
        
        // 密码md5加密
        String password = DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes());
        user.setUserPassword(password);
        return userMapper.insert(user) > 0;
    }
}
