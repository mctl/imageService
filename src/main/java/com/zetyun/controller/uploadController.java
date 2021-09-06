package com.zetyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import com.zetyun.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

        JSONObject result = new JSONObject();
        result.put("code", "1");
        result.put("data",fileName);
        return result;
    }
}
