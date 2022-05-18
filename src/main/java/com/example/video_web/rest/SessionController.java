package com.example.video_web.rest;

import com.example.video_web.entity.form.UserForm;
import com.example.video_web.entity.po.User;
import com.example.video_web.exception.user.UserCommonErrorType;
import com.example.video_web.exception.user.UserCommonException;
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

    @PostMapping("/login")
    public Result login(@Valid @RequestBody UserForm userForm) {

        // 校验用户是否存在
        if (!userService.isExist(userForm.toPo(User.class))) {
            throw new UserCommonException(UserCommonErrorType.USER_NOT_FOUND);
        }

        // 登录成功，写入Token
        // TODO

        return Result.success();
    }


    @PostMapping("/logout")
    public Result logout() {
        return null;
    }
}
