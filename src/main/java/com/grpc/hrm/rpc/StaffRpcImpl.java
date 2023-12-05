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
        StaffResponseOuterClass.StaffResponse response = staffFacade.saveStaff(request.getStaff());
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void getStaffInfo(StaffRequestOuterClass.StaffRequest1 request, StreamObserver<StaffResponseOuterClass.StaffResponse> responseObserver) {
        System.out.println("request= " + request);
        StaffResponseOuterClass.StaffResponse response = staffFacade.getStaffById(request.getStaffId());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getAllStaffInfo(StaffListRequestOuterClass.StaffListRequest request, StreamObserver<StaffListResponseOuterClass.StaffListResponse> responseObserver) {
        List<StaffOuterClass.Staff> staffs = staffFacade.getAllStaff();
        StaffListResponseOuterClass.StaffListResponse response = StaffListResponseOuterClass.StaffListResponse.newBuilder()
                .addAllStaff(staffs)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateStaff(StaffRequestOuterClass.StaffRequest request, StreamObserver<StaffResponseOuterClass.StaffResponse> responseObserver) {
        StaffResponseOuterClass.StaffResponse response = staffFacade.updateStaff(request.getStaff().getStaffId(), request.getStaff());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void removeStaff(StaffRequestOuterClass.StaffRequest1 request, StreamObserver<StatusResponseOuterClass.StatusResponse> responseObserver) {
        staffFacade.deleteStaff(request.getStaffId());
        StatusResponseOuterClass.StatusResponse response = StatusResponseOuterClass.StatusResponse.newBuilder()
                .setStatus("Staff deleted successfully!!")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
