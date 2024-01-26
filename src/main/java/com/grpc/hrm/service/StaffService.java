package com.grpc.hrm.service;

import com.grpc.hrm.model.Staff;
import com.grpc.hrm.model.TaxCalculation;

import java.util.List;

public interface StaffService {
    Staff saveStaff(Staff staff);

    Staff getStaffById(String staffId);

    List<Staff> getAllStaff(int pageNumber, int pageSize);

    Staff updateStaff(String staffId, Staff staff);

    String deleteStaff(String staffId);

    String addFileByStaffId(String staffId, String filePath);

    String addImageByStaffId(String staffId, String filePath);

    TaxCalculation calculateTax(String staffId);
}
