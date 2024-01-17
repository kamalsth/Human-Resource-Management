package com.grpc.hrm.repository;

import com.grpc.hrm.model.Staff;

import java.util.List;

public interface StaffRepository {
    public Staff saveStaff(Staff staff);
    public Staff getStaffById(String staffId);
    public List<Staff> getAllStaff();
    public Staff updateStaff(String staffId,Staff staff);
    public void deleteStaff(String staffId);

    public void addFileByStaffId(String staffId,String filePath);


    public void addImageByStaffId(String staffId,String filePath);

    public String getEmergencyContactNumber(String name);
}
