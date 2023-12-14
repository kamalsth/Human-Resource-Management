package com.grpc.hrm.client.controller;


import com.grpc.hrm.client.service.FileUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/file")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam(name = "staffId") int staffId) throws IOException {
        return fileUploadService.uploadFile(staffId,file);
    }

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file,@RequestParam(name = "staffId") int staffId) throws IOException {
        return fileUploadService.uploadImage(staffId,file);
    }
}
