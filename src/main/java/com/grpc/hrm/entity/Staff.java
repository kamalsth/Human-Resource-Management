package com.grpc.hrm.entity;

public class Staff {
    private int staffId;
    private String name;
    private String personalPhone;
    private String emergencyContactNumber;
    private String position;
    private String citizenshipPhoto;
    private String contactDocPdf;
    private long joinDate;
    private long contactRenewDate;

    public Staff(int staffId, String name, String personalPhone, String emergencyContactNumber, String position, String citizenshipPhoto, String contactDocPdf, long joinDate, long contactRenewDate) {
        this.staffId = staffId;
        this.name = name;
        this.personalPhone = personalPhone;
        this.emergencyContactNumber = emergencyContactNumber;
        this.position = position;
        this.citizenshipPhoto = citizenshipPhoto;
        this.contactDocPdf = contactDocPdf;
        this.joinDate = joinDate;
        this.contactRenewDate = contactRenewDate;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
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

    public long getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(long joinDate) {
        this.joinDate = joinDate;
    }

    public long getContactRenewDate() {
        return contactRenewDate;
    }

    public void setContactRenewDate(long contactRenewDate) {
        this.contactRenewDate = contactRenewDate;
    }
}
