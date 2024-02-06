package com.grpc.hrm.service;

import com.grpc.hrm.model.ConfirmLeaveRequest;
import com.grpc.hrm.model.LeaveRequestModel;
import com.grpc.hrm.model.LeaveStatus;

import java.util.List;



public interface LeaveService {
    LeaveRequestModel leaveRequest(LeaveRequestModel leaveRequestModel);

    List<LeaveRequestModel> getAllLeaveRequest(int pageNumber, int pageSize);

    LeaveRequestModel getLeaveRequestById(String id);

    LeaveRequestModel updateLeaveRequest(String id, LeaveRequestModel leaveRequestModel);

    String deleteLeaveRequest(String id);

    LeaveStatus confirmLeaveRequest(ConfirmLeaveRequest confirmLeaveRequest);

    List<LeaveRequestModel> getLeaveRequestListByUser(int pageNumber, int pageSize);
}
