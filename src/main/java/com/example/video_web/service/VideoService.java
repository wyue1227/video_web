package com.example.video_web.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.video_web.entity.po.Video;
import com.example.video_web.mapper.VideoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoService {

    @Resource
    VideoMapper videoMapper;

    public List<Video> getVideosByCollectionId(Integer collectionId) {
        QueryWrapper<Video> queryWrapper = new QueryWrapper();
        queryWrapper.eq("collection_id", collectionId);
        return videoMapper.selectList(queryWrapper);
    }
}
