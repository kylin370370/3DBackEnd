package com.example.aaa.controller;
import com.example.aaa.ImageInfo;
import com.example.aaa.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;
@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    private UrlService urlService;
    @GetMapping("/{path}")
    public List<ImageInfo> getImage(@PathVariable String path) {
//        List<String> urlList = new ArrayList<>();
//
//        if ("C_d_020".equals(path)) {
//            // 构建URL列表
//            System.out.println(path);
//            for (int i = 1; i <= 4; i++) {
//                String imageUrl = "https://stone-wall.obs.cn-east-3.myhuaweicloud.com/DZGCG/segment_image/C/d_020/" + i + ".png";
//                urlList.add(imageUrl);
//            }
//        }
//        else{
//        }
//
//        return urlList;
        return urlService.getImageInfo(path);
    }
}
