package com.grpc.hrm.endpoint;


import com.grpc.hrm.facade.LeaveFacade;
import com.ks.proto.common.StatusResponse;
import com.ks.proto.leave.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class LeaveRpcImpl extends LeaveServiceGrpc.LeaveServiceImplBase {
    private final LeaveFacade leaveFacade;

    public LeaveRpcImpl(LeaveFacade leaveFacade) {
        this.leaveFacade = leaveFacade;
    }

    @Override
    public void requestLeave(LeaveRequest request, StreamObserver<LeaveResponse> responseObserver) {
        responseObserver.onNext(leaveFacade.leaveRequest(request));
        responseObserver.onCompleted();
    }

    @Override
    public void getLeaveList(LeaveListRequest request, StreamObserver<LeaveListResponse> responseObserver) {
        responseObserver.onNext(leaveFacade.getAllLeaveRequest(request));
        responseObserver.onCompleted();
    }

    @Override
    public void getLeave(LeaveRequestById request, StreamObserver<LeaveResponse> responseObserver) {
        responseObserver.onNext(leaveFacade.getLeaveRequestById(request.getId()));
        responseObserver.onCompleted();
    }


    @Override
    public void updateLeave(LeaveRequest request, StreamObserver<LeaveResponse> responseObserver) {
        responseObserver.onNext(leaveFacade.updateLeaveRequest(request));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteLeave(LeaveRequestById request, StreamObserver<StatusResponse> responseObserver) {
        responseObserver.onNext(leaveFacade.deleteLeaveRequest(request.getId()));
        responseObserver.onCompleted();
    }

    @Override
    public void confirmLeave(ConfirmLeaveRequest request, StreamObserver<StatusResponse> responseObserver) {
        responseObserver.onNext(leaveFacade.confirmLeaveRequest(request));
        responseObserver.onCompleted();
    }

    @Override
    public void getLeaveRequestListByUser(LeaveListRequest request, StreamObserver<LeaveListResponse> responseObserver) {
        responseObserver.onNext(leaveFacade.getLeaveRequestListByUser(request));
        responseObserver.onCompleted();
    }
}
