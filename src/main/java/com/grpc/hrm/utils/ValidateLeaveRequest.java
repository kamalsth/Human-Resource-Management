package com.grpc.hrm.utils;

import com.ks.proto.leave.LeaveRequest;

public class ValidateLeaveRequest {
    public static void validateLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            throw new NullPointerException("LeaveRequest is null");

        } else if (leaveRequest.getFrom() == 0) {
            throw new IllegalArgumentException("From fields should not be empty");

        } else if (leaveRequest.getTo() == 0) {
            throw new IllegalArgumentException("To fields should not be empty");

        } else if (leaveRequest.getSubject().isEmpty()) {
            throw new IllegalArgumentException("Subject fields should not be empty");
        }

    }

    public static void validateId(String id) {
        if (id.isEmpty()) {
            throw new IllegalArgumentException("leaveId should not be empty");
        }
    }
}
