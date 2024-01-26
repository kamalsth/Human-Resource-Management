package com.grpc.hrm.endpoint;

import com.grpc.hrm.facade.NoticeFacade;
import com.ks.proto.common.StatusResponse;
import com.ks.proto.notice.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class NoticeRpcImpl extends NoticeServiceGrpc.NoticeServiceImplBase {

    private final NoticeFacade noticeFacade;

    public NoticeRpcImpl(NoticeFacade noticeFacade) {
        this.noticeFacade = noticeFacade;
    }

    @Override
    public void addNotice(NoticeRequest request, StreamObserver<NoticeResponse> responseObserver) {
        responseObserver.onNext(noticeFacade.saveNotice(request));
        responseObserver.onCompleted();
    }

    @Override
    public void updateNotice(NoticeRequest request, StreamObserver<NoticeResponse> responseObserver) {
        responseObserver.onNext(noticeFacade.updateNotice(request));
        responseObserver.onCompleted();
    }

    @Override
    public void getAllNotice(NoticeListRequest request, StreamObserver<NoticeListResponse> responseObserver) {
        responseObserver.onNext(noticeFacade.getAllNotice(request));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteNotice(NoticeRequestById request, StreamObserver<StatusResponse> responseObserver) {
        responseObserver.onNext(noticeFacade.deleteNotice(request.getNoticeId()));
        responseObserver.onCompleted();
    }
}
