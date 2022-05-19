package com.example.video_web.rest;

import javax.annotation.Resource;

import com.example.video_web.entity.form.UserForm;
import com.example.video_web.entity.po.User;
import com.example.video_web.entity.vo.Result;
import com.example.video_web.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Resource
    UserService userService;

    @PostMapping
    public Result<Boolean> addUser(@Valid @RequestBody UserForm userForm) {
        User insertUser = userForm.toPo(User.class);
        return Result.success(userService.addUser(insertUser));
    }
}