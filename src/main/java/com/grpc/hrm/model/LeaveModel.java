package com.grpc.hrm.model;

public class LeaveModel {
    private String id;
    private String from;
    private String to;
    private String subject;
    private LeaveStatus status;
    private int userId;

    public LeaveModel() {
    }

    public LeaveModel(String id, String from, String to, String subject, LeaveStatus status, int userId) {
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
