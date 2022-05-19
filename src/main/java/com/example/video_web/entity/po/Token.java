package com.example.video_web.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("token")
public class Token extends BasePo implements Serializable {

    private static final long serialVersionUID = 6797042239003520954L;
    
    @TableId(type = IdType.ASSIGN_UUID)
    private String tokenId;

    private LocalDateTime expireTime;

    private Integer userId;
}