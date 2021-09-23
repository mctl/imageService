package com.zetyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import com.zetyun.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Create by gaosh
 * @date: 2/9/21
 * @description:
 */

@RestController
public class uploadController {

    private final FileService fileService;

    public uploadController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value = "/upload", produces = "application/json; charset=UTF-8")
    @ResponseBody
//    @CrossOrigin(origins = "*", maxAge = 3600)
    public JSONObject uploadImage(@RequestParam("file") MultipartFile file) {
        String fileName = fileService.storeFile(file);
        List<String> imgsType = new ArrayList<>(Arrays.asList("image/jpg", "image/jpeg", "image/png"));


        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        data.put("name", fileName);
        data.put("path", "files/upload/" + fileName);
        data.put("isImage", imgsType.contains(file.getContentType()));

        result.put("code", "1");
        result.put("data",data);
        return result;
    }
}
