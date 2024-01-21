package com.grpc.hrm.service;

import com.grpc.hrm.model.Staff;
import com.grpc.hrm.model.TaxCalculation;

import java.util.List;

public interface StaffService {
    Staff saveStaff(Staff staff);

    Staff getStaffById(String staffId);

    List<Staff> getAllStaff(int pageNumber, int pageSize);

    Staff updateStaff(String staffId, Staff staff);

    void deleteStaff(String staffId);

    void addFileByStaffId(String staffId, String filePath);

    void addImageByStaffId(String staffId, String filePath);

    double taxCalculation(String staffId);

    TaxCalculation calculateTax(String staffId);
}
