package com.grpc.hrm.client.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService {
    public ResponseEntity<?> uploadFile(int staffId, MultipartFile file) throws IOException {
        String filePath = storeFileAndImage(staffId, file);
        sendFilePath(staffId, filePath);
        return ResponseEntity.ok().body("File upload successfully: " + filePath);
    }

    public ResponseEntity<?> uploadImage(int staffId, MultipartFile file) throws IOException {
        String filePath = storeFileAndImage(staffId, file);
        sendImagePath(staffId, filePath);
        return ResponseEntity.ok().body("Image upload successfully: " + filePath);
    }

    public String storeFileAndImage(int staffId, MultipartFile file) throws IOException {
        String UploadDir = "/media/kamal/Software/Treeleaf/output";
        String imageName = file.getOriginalFilename();
        Path uploadPath = Path.of(UploadDir, imageName);
        Files.copy(file.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
        String filePath = uploadPath.toString();
        System.out.println("File store successfully: ");
        return filePath;

    }

    public void sendFilePath(int staffId, String filePath) {
        GrpcClientService grpcClientService = new GrpcClientService("localhost", 9090);
        grpcClientService.callGrpcServer(staffId, filePath, false);
    }


    public void sendImagePath(int staffId, String filePath) {
        GrpcClientService grpcClientService = new GrpcClientService("localhost", 9090);
        grpcClientService.callGrpcServer(staffId, filePath, true);
    }

}
