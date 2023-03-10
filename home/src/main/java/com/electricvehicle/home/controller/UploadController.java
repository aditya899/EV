package com.electricvehicle.home.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.electricvehicle.home.model.*;
import com.electricvehicle.home.service.HomeService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/upload")
public class UploadController extends BaseController {
    
    @Autowired
    private HomeService homeService;

    @PostMapping("")
    public ResponseEntity<?> uploadFile(@RequestParam("stationImage") MultipartFile uploadFile) {
        ResponseResult rr = new ResponseResult();

        if (uploadFile.isEmpty()) {
            return ResponseEntity.ok().body("please select a file!");
        }

        try {
            String[] fileUrls = saveUploadedFiles(Arrays.asList(uploadFile));  
            rr.setMessage(getApiUrl() + fileUrls[0]); 
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
        rr.setStatusCode(200);
        return ResponseEntity.ok(rr);
    }

    private String[] saveUploadedFiles(List<MultipartFile> files) throws IOException {
        String[] fileUrls = new String[files.size()];
        int index = 0;
        for(MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            fileUrls[index] = homeService.storeFile(file);
            index++;
        }
        return fileUrls;
    }
}
