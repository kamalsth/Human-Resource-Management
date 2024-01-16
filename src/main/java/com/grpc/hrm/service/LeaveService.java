package com.grpc.hrm.service;

import com.grpc.hrm.model.ConfirmLeaveRequest;
import com.grpc.hrm.model.LeaveRequestModel;

import java.util.List;



public interface LeaveService {
    LeaveRequestModel leaveRequest(LeaveRequestModel leaveRequestModel);

    List<LeaveRequestModel> getAllLeaveRequest();

    LeaveRequestModel getLeaveRequestById(String id);

    void updateLeaveRequest(String id, LeaveRequestModel leaveRequestModel);

    void deleteLeaveRequest(String id);

    void confirmLeaveRequest(ConfirmLeaveRequest confirmLeaveRequest);

}
