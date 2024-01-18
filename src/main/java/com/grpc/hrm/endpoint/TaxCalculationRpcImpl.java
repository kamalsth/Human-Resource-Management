package com.grpc.hrm.endpoint;

import com.grpc.hrm.facade.StaffFacade;
import com.ks.proto.staff.StaffRequestById;
import com.ks.proto.staff.TaxCalResponse;
import com.ks.proto.staff.TaxServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class TaxCalculationRpcImpl extends TaxServiceGrpc.TaxServiceImplBase {
    private final StaffFacade staffFacade;

    public TaxCalculationRpcImpl(StaffFacade staffFacade) {
        this.staffFacade = staffFacade;
    }

    @Override
    public void calculateTax(StaffRequestById request, StreamObserver<TaxCalResponse> responseObserver) {
        try {
            responseObserver.onNext(staffFacade.calculateTax(request.getStaffId()));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(e);
        }
    }
}
