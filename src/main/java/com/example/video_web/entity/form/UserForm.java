package com.example.video_web.entity.form;

import com.example.video_web.entity.po.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 登录用Entity，前端 -> 后端
 */
@Getter
@Setter
public class UserForm extends BaseForm<User>{

    @NotBlank(message = "⼿机号码不能为空")
    @NotNull(message = "⼿机号不能为空")
    @Length(min = 11, max = 11, message = "⼿机号只能为11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "⼿机号格式有误")
    private String userPhone;

    @NotBlank(message = "密码不能为空")
    private String userPassword;

}
