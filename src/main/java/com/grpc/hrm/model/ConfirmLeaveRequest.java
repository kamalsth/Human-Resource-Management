package com.grpc.hrm.model;

public class ConfirmLeaveRequest {
    private String id;
    private LeaveStatus leaveStatus;

    public ConfirmLeaveRequest() {
    }

    public ConfirmLeaveRequest(String id, LeaveStatus leaveStatus) {
        this.id = id;
        this.leaveStatus = leaveStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LeaveStatus getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(LeaveStatus leaveStatus) {
        this.leaveStatus = leaveStatus;
    }
}
