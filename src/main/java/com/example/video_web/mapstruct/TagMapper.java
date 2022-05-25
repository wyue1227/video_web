package com.example.video_web.mapstruct;

import com.example.video_web.entity.po.Tag;
import com.example.video_web.entity.vo.TagVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TagMapper {

    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    TagVo tagToTagVo(Tag tag);

    List<TagVo> tagsToTagVos(List<Tag> tags);
}
