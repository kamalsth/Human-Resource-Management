package com.grpc.hrm.endpoint;

import com.grpc.hrm.facade.StaffFacade;
import com.ks.proto.staff.FileUploadRequest;
import com.ks.proto.staff.FileUploadResponse;
import com.ks.proto.staff.FileUploadServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class FileUploadRpcImpl extends FileUploadServiceGrpc.FileUploadServiceImplBase {


    private final StaffFacade staffFacade;

    public FileUploadRpcImpl(StaffFacade staffFacade) {
        this.staffFacade = staffFacade;
    }

    @Override
    public void uploadFile(FileUploadRequest request, StreamObserver<FileUploadResponse> responseObserver) {
        String filePath = request.getFilePath();
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
        staffFacade.addFileByStaffId(request.getStaffId(), request.getFilePath());

        responseObserver.onNext(FileUploadResponse.newBuilder()
                .setFileName(fileName)
                .setUploadStatus("File uploaded successfully")
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void uploadImage(FileUploadRequest request, StreamObserver<FileUploadResponse> responseObserver) {
        String filePath = request.getFilePath();
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
        staffFacade.addImageByStaffId(request.getStaffId(), request.getFilePath());
        responseObserver.onNext(FileUploadResponse.newBuilder()
                .setFileName(fileName)
                .setUploadStatus("Image uploaded successfully")
                .build());
        responseObserver.onCompleted();

   }
}
