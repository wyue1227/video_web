package com.example.video_web.rest;

import com.example.video_web.entity.po.Collection;
import com.example.video_web.entity.vo.Result;
import com.example.video_web.service.CollectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(("/collection"))
public class CollectionController {

    @Resource
    CollectionService collectionService;

    @GetMapping("/all")
    public Result getCollections() {
        return Result.success(collectionService.getAllCollection());
    }
}
