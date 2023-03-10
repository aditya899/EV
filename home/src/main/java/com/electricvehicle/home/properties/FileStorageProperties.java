package com.electricvehicle.home.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        if (uploadDir == null) {
            return "";
        }
        return uploadDir.replaceAll("\"", "");
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
