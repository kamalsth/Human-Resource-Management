package com.grpc.hrm.rpc;


import com.grpc.hrm.facade.StaffFacade;
import generatedClasses.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
public class StaffRpcImpl extends StaffServiceGrpc.StaffServiceImplBase {


    private final StaffFacade staffFacade;

    public StaffRpcImpl(StaffFacade staffFacade) {
        this.staffFacade = staffFacade;
    }

    @Override
    public void addStaff(StaffRequestOuterClass.StaffRequest request, StreamObserver<StaffResponseOuterClass.StaffResponse> responseObserver) {
        try {
            responseObserver.onNext(staffFacade.saveStaff(request.getStaff()));
            responseObserver.onCompleted();
        } catch (IllegalArgumentException e) {
            responseObserver.onError(e);
        }


    }

    @Override
    public void getStaffInfo(StaffRequestOuterClass.StaffRequest1 request, StreamObserver<StaffResponseOuterClass.StaffResponse> responseObserver) {
        try {
            responseObserver.onNext(staffFacade.getStaffById(request.getStaffId()));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(e);
        }

    }


    @Override
    public void getAllStaffInfo(StaffListRequestOuterClass.StaffListRequest request, StreamObserver<StaffListResponseOuterClass.StaffListResponse> responseObserver) {
        List<StaffOuterClass.Staff> staffs = staffFacade.getAllStaff();
        responseObserver.onNext(StaffListResponseOuterClass.StaffListResponse.newBuilder()
                .addAllStaff(staffs)
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateStaff(StaffRequestOuterClass.StaffRequest request, StreamObserver<StaffResponseOuterClass.StaffResponse> responseObserver) {
        try {
            responseObserver.onNext(staffFacade.updateStaff(request.getStaff().getStaffId(), request.getStaff()));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(e);
        }

    }

    @Override
    public void removeStaff(StaffRequestOuterClass.StaffRequest1 request, StreamObserver<StatusResponseOuterClass.StatusResponse> responseObserver) {
        try {
            staffFacade.deleteStaff(request.getStaffId());
            responseObserver.onNext(StatusResponseOuterClass.StatusResponse.newBuilder()
                    .setStatus("Staff deleted successfully!!")
                    .build());
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(e);
        }

    }
}
