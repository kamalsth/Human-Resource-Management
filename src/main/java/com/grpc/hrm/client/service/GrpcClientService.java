package com.grpc.hrm.client.service;

import com.ks.proto.staff.FileUploadRequest;
import com.ks.proto.staff.FileUploadResponse;
import com.ks.proto.staff.FileUploadServiceGrpc;
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


    private StreamObserver<FileUploadResponse> createResponseObserver() {
        return new StreamObserver<FileUploadResponse>() {
            @Override
            public void onNext(FileUploadResponse response) {
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
        StreamObserver<FileUploadResponse> responseObserver = createResponseObserver();

        FileUploadRequest request = FileUploadRequest.newBuilder()
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
