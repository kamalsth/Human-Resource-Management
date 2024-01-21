package com.grpc.hrm.repository;

import com.grpc.hrm.model.LeaveRequestModel;

import java.util.List;

public interface LeaveRepository {
    LeaveRequestModel leaveRequest(LeaveRequestModel leaveRequestModel);

    List<LeaveRequestModel> getAllLeaveRequest(int pageNumber, int pageSize);

    LeaveRequestModel getLeaveRequestById(String id);

    void updateLeaveRequest(String id, LeaveRequestModel leaveRequestModel);

    void deleteLeaveRequest(String id);

    void confirmLeaveRequest(LeaveRequestModel leaveRequestModel);


    String getUserIdFromUsername(String username);
}
