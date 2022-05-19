package com.example.video_web.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("video")
public class Video extends BasePo implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer videoId;

    private String videoTitle;

    private String videoUrl;

    private Long videoTime;

    private Integer collectionId;
}
