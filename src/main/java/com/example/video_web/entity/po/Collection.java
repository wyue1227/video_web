package com.example.video_web.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("collection")
public class Collection extends BasePo implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer collectionId;

    private String collectionTitle;

    private String collectionCover;

    private Long collectionTime;

    @TableField(exist = false)
    private List<Tag> tags;

    private Integer videoCount;

}
