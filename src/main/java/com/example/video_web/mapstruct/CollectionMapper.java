package com.example.video_web.mapstruct;

import com.example.video_web.entity.po.Collection;
import com.example.video_web.entity.po.Tag;
import com.example.video_web.entity.vo.CollectionVo;
import com.example.video_web.entity.vo.TagVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CollectionMapper {

    CollectionMapper INSTANCE = Mappers.getMapper(CollectionMapper.class);

    CollectionVo collectionToCollectionVo(Collection collection);

    List<CollectionVo> collectionsToCollectionVos(List<Collection> collections);
}
