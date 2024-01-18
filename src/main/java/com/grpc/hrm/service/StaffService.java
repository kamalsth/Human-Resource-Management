package com.grpc.hrm.service;

import com.grpc.hrm.model.Staff;
import com.grpc.hrm.model.TaxCalculation;

import java.util.List;

public interface StaffService {
    public Staff saveStaff(Staff staff);
    public Staff getStaffById(String staffId);
    public List<Staff> getAllStaff();
    public Staff updateStaff(String staffId,Staff staff);
    public void deleteStaff(String staffId);

    public void addFileByStaffId(String staffId,String filePath);
    public void addImageByStaffId(String staffId,String filePath);

    double taxCalculation(String staffId);

    TaxCalculation calculateTax(String staffId);
}
