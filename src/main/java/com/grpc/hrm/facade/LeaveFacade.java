package com.grpc.hrm.facade;

import com.grpc.hrm.mapper.MapperConfig;
import com.grpc.hrm.model.LeaveRequestModel;
import com.grpc.hrm.service.LeaveService;
import com.grpc.hrm.utils.ValidateLeaveRequest;
import com.ks.proto.common.StatusResponse;
import com.ks.proto.leave.ConfirmLeaveRequest;
import com.ks.proto.leave.LeaveRequest;
import com.ks.proto.leave.LeaveResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveFacade {
    private final LeaveService leaveService;

    public LeaveFacade(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    public LeaveResponse leaveRequest(LeaveRequest leaveRequest) {
        ValidateLeaveRequest.validateLeaveRequest(leaveRequest);
        LeaveRequestModel leaveRequestModel = MapperConfig.INSTANCE.mapTOLeaveRequestModel(leaveRequest);
        return MapperConfig.INSTANCE.mapToLeaveRequestProto(leaveService.leaveRequest(leaveRequestModel));
    }


    public List<LeaveResponse> getAllLeaveRequest(int pageNumber, int pageSize) {
        List<LeaveRequestModel> leaveRequestModels = leaveService.getAllLeaveRequest(pageNumber, pageSize);
        return leaveRequestModels.stream().map(MapperConfig.INSTANCE::mapToLeaveRequestProto).toList();
    }

    public LeaveResponse getLeaveRequestById(String id) {
        ValidateLeaveRequest.validateId(id);
        return MapperConfig.INSTANCE.mapToLeaveRequestProto(leaveService.getLeaveRequestById(id));
    }

    public LeaveResponse updateLeaveRequest(LeaveRequest request) {
        ValidateLeaveRequest.validateLeaveRequest(request);
        LeaveRequestModel leaveRequestModel = MapperConfig.INSTANCE.mapTOLeaveRequestModel(request);
        leaveService.updateLeaveRequest(request.getId(), leaveRequestModel);
        return MapperConfig.INSTANCE.mapToLeaveRequestProto(leaveRequestModel);
    }

    public StatusResponse deleteLeaveRequest(String id) {
        ValidateLeaveRequest.validateId(id);
        return StatusResponse.newBuilder()
                .setStatus(leaveService.deleteLeaveRequest(id))
                .build();
    }

    public StatusResponse confirmLeaveRequest(ConfirmLeaveRequest request) {
        ValidateLeaveRequest.validateId(request.getId());
        return StatusResponse.newBuilder()
                .setStatus(leaveService.confirmLeaveRequest(MapperConfig.INSTANCE.mapToConfirmLeaveRequest(request)).name())
                .build();
    }

    public List<LeaveResponse> getLeaveRequestListByUser(int pageNumber, int pageSize) {
        List<LeaveRequestModel> leaveRequestModels = leaveService.getLeaveRequestListByUser(pageNumber, pageSize);
        return leaveRequestModels.stream().map(MapperConfig.INSTANCE::mapToLeaveRequestProto).toList();
    }
}
