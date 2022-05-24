package com.example.video_web.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.video_web.entity.po.Tag;
import com.example.video_web.mapper.TagMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagService {

    @Resource
    TagMapper tagMapper;

    public List<Tag> getTagsById(Integer collectionId) {
        QueryWrapper<Tag> queryWrapper = new QueryWrapper();
        queryWrapper.eq("collection_id", collectionId);
        return tagMapper.selectList(queryWrapper);
    }
}
