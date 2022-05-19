package com.example.video_web.rest;

import com.example.video_web.entity.form.UserForm;
import com.example.video_web.entity.po.User;
import com.example.video_web.exception.user.UserCommonErrorType;
import com.example.video_web.exception.user.UserCommonException;
import com.example.video_web.service.TokenService;
import com.example.video_web.service.UserService;
import com.example.video_web.entity.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class SessionController {

    @Resource
    private UserService userService;

    @Resource
    private TokenService tokenService;

    @PostMapping("/login")
    public Result login(@Valid @RequestBody UserForm userForm) {

        // 校验用户是否存在
        User user = userService.selectUser(userForm.toPo(User.class));
        if (user == null) {
            throw new UserCommonException(UserCommonErrorType.USER_NOT_FOUND);
        }

        // 登录成功，写入Token
        String token = tokenService.addNewToken(user.getUserId());

        // 返回token给前端
        return Result.success(token);
    }


    @PostMapping("/logout")
    public Result logout() {
        return null;
    }
}
