package com.grpc.hrm.model;

public class TaxCalculation {
    private String staffName;
    private String maritalStatus;
    private double monthlySalary;
    private double annualSalary;
    private double totalTax;


    public TaxCalculation(String staffName, String maritalStatus, double monthlySalary, double annualSalary, double totalTax) {
        this.staffName = staffName;
        this.maritalStatus = maritalStatus;
        this.monthlySalary = monthlySalary;
        this.annualSalary = annualSalary;
        this.totalTax = totalTax;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }
}
