package com.example.video_web.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class CollectionVo {

    private Integer collectionId;

    private String collectionTitle;

    private String collectionCover;

    private Long collectionTime;

    private List<TagVo> tags;

    private Integer videoCount;

}
