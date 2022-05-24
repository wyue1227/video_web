package com.example.video_web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.video_web.entity.po.Collection;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectionMapper extends BaseMapper<Collection> {

    @Results({
            @Result(id = true,
                    column = "collection_id",
                    property = "collectionId"),
            @Result(column = "collection_id",
                    property = "tags",
                    many = @Many(select = "com.example.video_web.mapper.TagMapper.selectTagsByCollectionId"))
    })
    @Select("select * from collection")
    List<Collection> getAllCollectionWithTags();
}
