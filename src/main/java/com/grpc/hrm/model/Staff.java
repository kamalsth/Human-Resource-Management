package com.grpc.hrm.model;

public class Staff {
    private String staffId;
    private String name;
    private String personalPhone;
    private String emergencyContactNumber;
    private String position;
    private String citizenshipPhoto;
    private String contactDocPdf;
    private String joinDate;
    private String contactRenewDate;
    private double salary;

    private MaritalStatus maritalStatus;
    private String email;

    public Staff(String staffId, String name, String personalPhone, String emergencyContactNumber, String position, String citizenshipPhoto, String contactDocPdf, String joinDate, String contactRenewDate, double salary, MaritalStatus maritalStatus, String email) {
        this.staffId = staffId;
        this.name = name;
        this.personalPhone = personalPhone;
        this.emergencyContactNumber = emergencyContactNumber;
        this.position = position;
        this.citizenshipPhoto = citizenshipPhoto;
        this.contactDocPdf = contactDocPdf;
        this.joinDate = joinDate;
        this.contactRenewDate = contactRenewDate;
        this.salary = salary;
        this.maritalStatus = maritalStatus;
        this.email = email;
    }

    public Staff(){

    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalPhone() {
        return personalPhone;
    }

    public void setPersonalPhone(String personalPhone) {
        this.personalPhone = personalPhone;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCitizenshipPhoto() {
        return citizenshipPhoto;
    }

    public void setCitizenshipPhoto(String citizenshipPhoto) {
        this.citizenshipPhoto = citizenshipPhoto;
    }

    public String getContactDocPdf() {
        return contactDocPdf;
    }

    public void setContactDocPdf(String contactDocPdf) {
        this.contactDocPdf = contactDocPdf;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getContactRenewDate() {
        return contactRenewDate;
    }

    public void setContactRenewDate(String contactRenewDate) {
        this.contactRenewDate = contactRenewDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
