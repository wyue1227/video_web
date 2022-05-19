package com.example.video_web.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.video_web.entity.po.Collection;
import com.example.video_web.mapper.CollectionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectionService {

    @Resource
    CollectionMapper collectionMapper;

    public List<Collection> getAllCollection() {
        QueryWrapper<Collection> queryWrapper = new QueryWrapper();
        queryWrapper.isNotNull("collection_id");
        return collectionMapper.selectList(queryWrapper);
    }
}
