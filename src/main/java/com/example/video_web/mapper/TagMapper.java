package com.example.video_web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.video_web.entity.po.Tag;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {

    @Select("select * from tag where collection_id = #{id}")
    List<Tag> selectTagsByCollectionId(@Param("id") Integer collectionId);
}
