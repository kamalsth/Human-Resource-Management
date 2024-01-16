package com.grpc.hrm.service.serviceimpl;

import com.grpc.hrm.model.ConfirmLeaveRequest;
import com.grpc.hrm.model.LeaveRequestModel;
import com.grpc.hrm.repository.LeaveRepository;
import com.grpc.hrm.service.LeaveService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveServiceImpl(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @Override
    public LeaveRequestModel leaveRequest(LeaveRequestModel leaveRequestModel) {
        System.out.println("service");
        System.out.println("LeaveRequestModel="+leaveRequestModel);
        //generate id
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().substring(0,32);
        leaveRequestModel.setId(id);
        System.out.println("after set id="+leaveRequestModel);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        int userId= leaveRepository.getUserIdFromUsername(username);

        leaveRequestModel.setUserId(userId);
        return leaveRepository.leaveRequest(leaveRequestModel);
    }

    @Override
    public List<LeaveRequestModel> getAllLeaveRequest() {
        return leaveRepository.getAllLeaveRequest();
    }

    @Override
    public LeaveRequestModel getLeaveRequestById(String id) {
        LeaveRequestModel leaveRequestModel = leaveRepository.getLeaveRequestById(id);
        if(leaveRequestModel == null){
            throw new RuntimeException("Leave Request not found for id : " + id);
        }
        return leaveRequestModel;
    }

    @Override
    public void updateLeaveRequest(String id, LeaveRequestModel leaveRequestModel) {
        LeaveRequestModel leaveRequestModel1 = leaveRepository.getLeaveRequestById(id);
        if(leaveRequestModel1 == null){
            throw new RuntimeException("Leave Request not found for id : " + id);
        }
        System.out.println("id="+id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        int userId= leaveRepository.getUserIdFromUsername(username);
        leaveRequestModel.setUserId(userId);
        leaveRepository.updateLeaveRequest(id, leaveRequestModel);
    }

    @Override
    public void deleteLeaveRequest(String id) {
        LeaveRequestModel leaveRequestModel = leaveRepository.getLeaveRequestById(id);
        if(leaveRequestModel == null){
            throw new RuntimeException("Leave Request not found for id : " + id);
        }
        leaveRepository.deleteLeaveRequest(id);
    }

    @Override
    public void confirmLeaveRequest(ConfirmLeaveRequest confirmLeaveRequest) {
        LeaveRequestModel leaveRequestModel = leaveRepository.getLeaveRequestById(confirmLeaveRequest.getId());
        if(leaveRequestModel == null){
            throw new RuntimeException("Leave Request not found for id : " + confirmLeaveRequest.getId());
        }
        leaveRequestModel.setStatus(confirmLeaveRequest.getLeaveStatus());
        leaveRepository.confirmLeaveRequest(leaveRequestModel);
    }
}
