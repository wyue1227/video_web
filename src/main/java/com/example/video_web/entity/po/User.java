package com.example.video_web.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User extends BasePo implements Serializable {

    private static final long serialVersionUID = -2841841790287894335L;

    private int userId;

    private String userPhone;

    private String userName;

    private String userPassword;
}
