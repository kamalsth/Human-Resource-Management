package com.grpc.hrm.client.service;

import generatedClasses.FileUpload;
import generatedClasses.FileUploadServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class GrpcClientService {
    private final String grpcServerAddress;
    private final int grpcServerPort;

    public GrpcClientService(String grpcServerAddress, int grpcServerPort) {
        this.grpcServerAddress = grpcServerAddress;
        this.grpcServerPort = grpcServerPort;
    }


    private ManagedChannel createChannel() {
        return ManagedChannelBuilder.forAddress(grpcServerAddress, grpcServerPort)
                .usePlaintext()
                .build();
    }


    private StreamObserver<FileUpload.FileUploadResponse> createResponseObserver() {
        return new StreamObserver<FileUpload.FileUploadResponse>() {
            @Override
            public void onNext(FileUpload.FileUploadResponse response) {
                System.out.println("gRPC Response: " + response);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("gRPC Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("gRPC Call Completed");
            }
        };
    }

    public void callGrpcServer(int staffId, String filePath, boolean isImage) {
        ManagedChannel channel = createChannel();
        FileUploadServiceGrpc.FileUploadServiceStub stub = FileUploadServiceGrpc.newStub(channel);
        StreamObserver<FileUpload.FileUploadResponse> responseObserver = createResponseObserver();

        FileUpload.FileUploadRequest request = FileUpload.FileUploadRequest.newBuilder()
                .setStaffId(staffId)
                .setFilePath(filePath)
                .build();

        if (isImage) {
            stub.uploadImage(request, responseObserver);
        } else {
            stub.uploadFile(request, responseObserver);
        }

        channel.shutdown();
    }
}
