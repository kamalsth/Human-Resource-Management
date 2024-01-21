package com.grpc.hrm.facade;

import com.grpc.hrm.mapper.MapperConfig;
import com.grpc.hrm.model.LeaveRequestModel;
import com.grpc.hrm.service.LeaveService;
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
        LeaveRequestModel leaveRequestModel = MapperConfig.INSTANCE.mapTOLeaveRequestModel(leaveRequest);
        return MapperConfig.INSTANCE.mapToLeaveRequestProto(leaveService.leaveRequest(leaveRequestModel));
    }


    public List<LeaveResponse> getAllLeaveRequest(int pageNumber, int pageSize) {
        List<LeaveRequestModel> leaveRequestModels = leaveService.getAllLeaveRequest(pageNumber,pageSize);
        return leaveRequestModels.stream().map(MapperConfig.INSTANCE::mapToLeaveListProto).toList();
    }

    public LeaveResponse getLeaveRequestById(String id) {
        return MapperConfig.INSTANCE.mapToLeaveRequestProto(leaveService.getLeaveRequestById(id));
    }

    public LeaveResponse updateLeaveRequest(LeaveRequest request) {
        LeaveRequestModel leaveRequestModel = MapperConfig.INSTANCE.mapTOLeaveRequestModel(request);
        leaveService.updateLeaveRequest(request.getId(), leaveRequestModel);
        return MapperConfig.INSTANCE.mapToLeaveRequestProto(leaveRequestModel);
    }

    public StatusResponse deleteLeaveRequest(String id) {
        leaveService.deleteLeaveRequest(id);
        return StatusResponse.newBuilder()
                .setStatus("Leave request deleted successfully")
                .build();
    }

    public StatusResponse confirmLeaveRequest(ConfirmLeaveRequest request) {
        leaveService.confirmLeaveRequest(MapperConfig.INSTANCE.mapToConfirmLeaveRequest(request));
        return StatusResponse.newBuilder()
                .setStatus("Leave request confirmed successfully")
                .build();
    }
}
