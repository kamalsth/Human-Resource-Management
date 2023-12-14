package com.grpc.hrm.rpc;

import com.grpc.hrm.facade.StaffFacade;
import generatedClasses.FileUpload;
import generatedClasses.FileUploadServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class FileUploadGrpcImpl extends FileUploadServiceGrpc.FileUploadServiceImplBase {


    private final StaffFacade staffFacade;

    public FileUploadGrpcImpl(StaffFacade staffFacade) {
        this.staffFacade = staffFacade;
    }

    @Override
    public void uploadFile(FileUpload.FileUploadRequest request, StreamObserver<FileUpload.FileUploadResponse> responseObserver) {
        String filePath = request.getFilePath();
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
        staffFacade.addFileByStaffId(request.getStaffId(), request.getFilePath());

        responseObserver.onNext(FileUpload.FileUploadResponse.newBuilder()
                .setFileName(fileName)
                .setUploadStatus("File uploaded successfully")
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void uploadImage(FileUpload.FileUploadRequest request, StreamObserver<FileUpload.FileUploadResponse> responseObserver) {
        String filePath = request.getFilePath();
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
        staffFacade.addImageByStaffId(request.getStaffId(), request.getFilePath());
        responseObserver.onNext(FileUpload.FileUploadResponse.newBuilder()
                .setFileName(fileName)
                .setUploadStatus("Image uploaded successfully")
                .build());
        responseObserver.onCompleted();

   }
}
