package com.zetyun.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Create by gaoshaohong-a
 * @date: 4/9/21
 * @description:
 */
@ConfigurationProperties(prefix = "file")
public class FileProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
