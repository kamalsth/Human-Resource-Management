package com.grpc.hrm.model;

public class Staff {
    private String staffId;
    private String name;
    private String personalPhone;
    private String emergencyContactNumber;
    private String position;
    private String citizenshipPhoto;
    private String contactDocPdf;
    private long joinDate;
    private long contactRenewDate;
    private double salary;

    private MaritalStatus maritalStatus;
    private String email;

    private double socialSecurityFund;
    private double employeesProvidentFund;
    private double citizenInvestmentTrust;
    private double insurance;

    public Staff(String staffId, String name, String personalPhone, String emergencyContactNumber, String position, String citizenshipPhoto, String contactDocPdf, long joinDate, long contactRenewDate, double salary, MaritalStatus maritalStatus, String email, double socialSecurityFund, double employeesProvidentFund, double citizenInvestmentTrust, double insurance) {
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
        this.socialSecurityFund = socialSecurityFund;
        this.employeesProvidentFund = employeesProvidentFund;
        this.citizenInvestmentTrust = citizenInvestmentTrust;
        this.insurance = insurance;
    }

    public Staff() {

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

    public double getSocialSecurityFund() {
        return socialSecurityFund;
    }

    public void setSocialSecurityFund(double socialSecurityFund) {
        this.socialSecurityFund = socialSecurityFund;
    }

    public double getEmployeesProvidentFund() {
        return employeesProvidentFund;
    }

    public void setEmployeesProvidentFund(double employeesProvidentFund) {
        this.employeesProvidentFund = employeesProvidentFund;
    }

    public double getCitizenInvestmentTrust() {
        return citizenInvestmentTrust;
    }

    public void setCitizenInvestmentTrust(double citizenInvestmentTrust) {
        this.citizenInvestmentTrust = citizenInvestmentTrust;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }
}
