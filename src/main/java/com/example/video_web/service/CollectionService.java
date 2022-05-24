package com.example.video_web.service;

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
        return collectionMapper.getAllCollectionWithTags();
    }
}
