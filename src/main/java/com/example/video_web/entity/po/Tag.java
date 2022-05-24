package com.example.video_web.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Tag extends BasePo implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer tagId;

    private String tagBackgroundColor;

    private String tagBorderColor;

    private String tagFontColor;

    private String tagTitle;

    private Integer collectionId;
}
