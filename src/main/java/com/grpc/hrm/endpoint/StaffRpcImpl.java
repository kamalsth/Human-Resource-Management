package com.grpc.hrm.endpoint;


import com.grpc.hrm.facade.StaffFacade;
import com.ks.proto.common.StatusResponse;
import com.ks.proto.staff.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class StaffRpcImpl extends StaffServiceGrpc.StaffServiceImplBase {


    private final StaffFacade staffFacade;

    public StaffRpcImpl(StaffFacade staffFacade) {
        this.staffFacade = staffFacade;
    }

    @Override
    public void addStaff(StaffRequest request, StreamObserver<StaffResponse> responseObserver) {
        try {
            responseObserver.onNext(staffFacade.saveStaff(request.getStaff()));
            responseObserver.onCompleted();
        } catch (IllegalArgumentException e) {
            responseObserver.onError(e);
        }


    }

    @Override
    public void getStaffInfo(StaffRequestById request, StreamObserver<StaffResponse> responseObserver) {
        try {
            responseObserver.onNext(staffFacade.getStaffById(request.getStaffId()));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(e);
        }

    }


    @Override
    public void getAllStaffInfo(StaffListRequest  request, StreamObserver<StaffListResponse> responseObserver) {
        responseObserver.onNext(staffFacade.getAllStaff(request));
        responseObserver.onCompleted();
    }

    @Override
    public void updateStaff(StaffRequest request, StreamObserver<StaffResponse> responseObserver) {
        try {
            responseObserver.onNext(staffFacade.updateStaff(request.getStaff().getStaffId(), request.getStaff()));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(e);
        }

    }

    @Override
    public void removeStaff(StaffRequestById request, StreamObserver<StatusResponse> responseObserver) {
        try {
            responseObserver.onNext(staffFacade.deleteStaff(request.getStaffId()));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(e);
        }

    }


}
