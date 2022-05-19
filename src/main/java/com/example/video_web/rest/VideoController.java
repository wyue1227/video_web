package com.example.video_web.rest;

import com.example.video_web.entity.vo.Result;
import com.example.video_web.service.CollectionService;
import com.example.video_web.service.VideoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Resource
    VideoService videoService;

    @PostMapping("/upload")
    @ResponseBody
    public Result upload() {
        return null;
    }

    @GetMapping("/{collectionId}")
    public Result getVideosByCollectionId(@PathVariable Integer collectionId) {

        return Result.success(videoService.getVideosByCollectionId(collectionId));

    }
}
