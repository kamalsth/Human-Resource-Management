package com.grpc.hrm.repository;

import com.grpc.hrm.model.Staff;

import java.util.List;

public interface StaffRepository {
    Staff saveStaff(Staff staff);

    Staff getStaffById(String staffId);

    List<Staff> getAllStaff();

    Staff updateStaff(String staffId, Staff staff);

    void deleteStaff(String staffId);

    void addFileByStaffId(String staffId, String filePath);


    void addImageByStaffId(String staffId, String filePath);

    Staff getStaffByEmail(String email);

    Staff getStaffByEmergencyContactNumber(String emergencyContactNumber);
}
