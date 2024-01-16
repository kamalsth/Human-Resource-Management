package com.grpc.hrm.facade;

import com.grpc.hrm.config.MapperConfig;
import com.grpc.hrm.model.LeaveRequestModel;
import com.grpc.hrm.service.LeaveService;
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
        System.out.println("facade");
        LeaveRequestModel leaveRequestModel = MapperConfig.INSTANCE.mapTOLeaveRequestModel(leaveRequest);
        return MapperConfig.INSTANCE.mapToLeaveRequestProto(leaveService.leaveRequest(leaveRequestModel));
    }


    public List<LeaveResponse> getAllLeaveRequest() {
        List<LeaveRequestModel> leaveRequestModels = leaveService.getAllLeaveRequest();
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

    public void deleteLeaveRequest(String id) {
        leaveService.deleteLeaveRequest(id);
    }

    public void confirmLeaveRequest(ConfirmLeaveRequest request) {
        com.grpc.hrm.model.ConfirmLeaveRequest confirmLeaveRequest = MapperConfig.INSTANCE.mapToConfirmLeaveRequest(request);
        leaveService.confirmLeaveRequest(confirmLeaveRequest);
    }
}
