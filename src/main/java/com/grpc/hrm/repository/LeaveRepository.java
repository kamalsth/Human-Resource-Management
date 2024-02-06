package com.grpc.hrm.repository;

import com.grpc.hrm.model.LeaveRequestModel;
import com.grpc.hrm.model.LeaveStatus;

import java.util.List;

public interface LeaveRepository {
    LeaveRequestModel leaveRequest(LeaveRequestModel leaveRequestModel);

    List<LeaveRequestModel> getAllLeaveRequest(int pageNumber, int pageSize);

    LeaveRequestModel getLeaveRequestById(String id);

    LeaveRequestModel updateLeaveRequest(String id, LeaveRequestModel leaveRequestModel);

    void deleteLeaveRequest(String id);

    LeaveStatus confirmLeaveRequest(LeaveRequestModel leaveRequestModel);


    String getUserIdFromUsername(String username);

    List<LeaveRequestModel> getLeaveRequestListByUser(String userId, int pageNumber, int pageSize);


    boolean getPendingLeaveRequestByUserId(String userId);
}
