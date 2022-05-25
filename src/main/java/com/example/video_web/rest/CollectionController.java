package com.example.video_web.rest;

import com.example.video_web.entity.vo.CollectionVo;
import com.example.video_web.entity.vo.Result;
import com.example.video_web.entity.vo.TagVo;
import com.example.video_web.mapstruct.CollectionMapper;
import com.example.video_web.service.CollectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping(("/collection"))
public class CollectionController {

    @Resource
    CollectionService collectionService;

    @GetMapping("/all")
    public Result getCollections() {
        List<CollectionVo> result = CollectionMapper.INSTANCE.collectionsToCollectionVos(collectionService.getAllCollection());
        for (CollectionVo tmp :
                result) {
            for (TagVo tmpTag :
                    tmp.getTags()) {
                if (tmpTag.getTagTitle().equals("课时")) {
                    tmpTag.setTagTitle(tmp.getVideoCount() + "课时");
                } else if (tmpTag.getTagTitle().equals("小时")) {
                    DecimalFormat df   = new DecimalFormat("######0.0");
                    Double videoTime = Double.valueOf(tmp.getCollectionTime());
                    if (videoTime < 60) {
                        tmpTag.setTagTitle(df.format(videoTime) + "秒");
                    } else if (videoTime < 360) {
                        tmpTag.setTagTitle(df.format(videoTime / 60.0) + "分");
                    } else {
                        tmpTag.setTagTitle(df.format(videoTime / 3600.0) + "小时");
                    }
                }
            }

        }

        return Result.success(result);
    }
}
