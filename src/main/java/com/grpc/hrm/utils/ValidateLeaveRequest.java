package com.grpc.hrm.utils;

import com.ks.proto.leave.LeaveRequest;

public class ValidateLeaveRequest {
    public static void validateLeaveRequest(LeaveRequest leaveRequest){
        if(leaveRequest==null){
            throw new NullPointerException("LeaveRequest is null");
        }
        if(leaveRequest.getFrom()==0 || leaveRequest.getTo()==0 || leaveRequest.getSubject().isEmpty()) {
            throw new IllegalArgumentException("Fields should not be empty");
        }
    }

    public static void validateId(String id) {
        if(id.isEmpty()){
            throw new IllegalArgumentException("leaveId should not be empty");
        }
    }
}
