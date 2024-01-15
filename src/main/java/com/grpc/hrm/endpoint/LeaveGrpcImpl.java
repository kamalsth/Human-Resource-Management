package com.grpc.hrm.endpoint;


import com.google.protobuf.Empty;
import com.ks.proto.common.StatusResponse;
import com.ks.proto.leave.*;
import io.grpc.stub.StreamObserver;

public class LeaveGrpcImpl extends LeaveServiceGrpc.LeaveServiceImplBase {

    @Override
    public void requestLeave(LeaveRequest request, StreamObserver<LeaveResponse> responseObserver) {
        super.requestLeave(request, responseObserver);
    }

    @Override
    public void getLeaveList(Empty request, StreamObserver<LeaveListResponse> responseObserver) {
        super.getLeaveList(request, responseObserver);
    }

    @Override
    public void getLeave(LeaveRequest request, StreamObserver<LeaveResponse> responseObserver) {
        super.getLeave(request, responseObserver);
    }

    @Override
    public void updateLeave(LeaveRequest request, StreamObserver<LeaveResponse> responseObserver) {
        super.updateLeave(request, responseObserver);
    }

    @Override
    public void deleteLeave(LeaveRequestById request, StreamObserver<StatusResponse> responseObserver) {
        super.deleteLeave(request, responseObserver);
    }

    @Override
    public void confirmLeave(ConfirmLeaveRequest request, StreamObserver<StatusResponse> responseObserver) {
        super.confirmLeave(request, responseObserver);
    }
}
