package com.grpc.hrm.model;

public class LeaveRequestModel {
    private String id;
    private long from;
    private long to;
    private String subject;
    private LeaveStatus status;
    private String userId;

    public LeaveRequestModel() {
    }

    public LeaveRequestModel(String id, long from, long to, String subject, LeaveStatus status, String userId) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.status = status;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LeaveRequestModel{" +
                "id='" + id + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
