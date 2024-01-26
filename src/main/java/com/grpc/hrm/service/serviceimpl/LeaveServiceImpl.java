package com.grpc.hrm.service.serviceimpl;

import com.grpc.hrm.model.ConfirmLeaveRequest;
import com.grpc.hrm.model.LeaveRequestModel;
import com.grpc.hrm.model.LeaveStatus;
import com.grpc.hrm.repository.LeaveRepository;
import com.grpc.hrm.service.LeaveService;
import com.grpc.hrm.utils.GenerateUUID;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveServiceImpl(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @Override
    public LeaveRequestModel leaveRequest(LeaveRequestModel leaveRequestModel) {
        leaveRequestModel.setId(GenerateUUID.generateID());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        leaveRequestModel.setUserId(leaveRepository.getUserIdFromUsername(username));
        return leaveRepository.leaveRequest(leaveRequestModel);
    }

    @Override
    public List<LeaveRequestModel> getAllLeaveRequest(int pageNumber, int pageSize) {
        return leaveRepository.getAllLeaveRequest(pageNumber, pageSize);
    }

    @Override
    public LeaveRequestModel getLeaveRequestById(String id) {
        LeaveRequestModel leaveRequestModel = leaveRepository.getLeaveRequestById(id);
        if (leaveRequestModel == null) {
            throw new RuntimeException("Leave Request not found for id : " + id);
        }
        return leaveRequestModel;
    }

    @Override
    public void updateLeaveRequest(String id, LeaveRequestModel leaveRequestModel) {
        LeaveRequestModel leaveRequestModel1 = leaveRepository.getLeaveRequestById(id);
        if (leaveRequestModel1 == null) {
            throw new RuntimeException("Leave Request not found for id : " + id);
        }
        System.out.println("id=" + id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String userId = leaveRepository.getUserIdFromUsername(username);
        leaveRequestModel.setUserId(userId);
        leaveRepository.updateLeaveRequest(id, leaveRequestModel);
    }

    @Override
    public String deleteLeaveRequest(String id) {
        LeaveRequestModel leaveRequestModel = leaveRepository.getLeaveRequestById(id);
        if (leaveRequestModel == null) {
            throw new RuntimeException("Leave Request not found for id : " + id);
        }
        leaveRepository.deleteLeaveRequest(id);
        return "Leave Request deleted successfully";
    }

    @Override
    public LeaveStatus confirmLeaveRequest(ConfirmLeaveRequest confirmLeaveRequest) {
        LeaveRequestModel leaveRequestModel = leaveRepository.getLeaveRequestById(confirmLeaveRequest.getId());
        if (leaveRequestModel == null) {
            throw new RuntimeException("Leave Request not found for id : " + confirmLeaveRequest.getId());
        }
        leaveRequestModel.setStatus(confirmLeaveRequest.getLeaveStatus());
        LeaveStatus status = leaveRepository.confirmLeaveRequest(leaveRequestModel);
        if (status == null) {
            throw new RuntimeException("Leave Request not found for id : " + confirmLeaveRequest.getId());
        } else if (status == LeaveStatus.APPROVED) {
            return LeaveStatus.APPROVED;
        } else if (status == LeaveStatus.DECLINED) {
            return LeaveStatus.DECLINED;
        }
        return LeaveStatus.PENDING;
    }

    @Override
    public List<LeaveRequestModel> getLeaveRequestListByUser(int pageNumber, int pageSize) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String userId = leaveRepository.getUserIdFromUsername(username);
        if (userId.isEmpty()) {
            throw new RuntimeException("User not found for username : " + username);
        }
        return leaveRepository.getLeaveRequestListByUser(userId, pageNumber, pageSize);
    }
}
