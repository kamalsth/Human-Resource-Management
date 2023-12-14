package com.grpc.hrm.repository;

import com.grpc.hrm.entity.Staff;

import java.util.List;

public interface StaffRepository {
    public Staff saveStaff(Staff staff);
    public Staff getStaffById(int staffId);
    public List<Staff> getAllStaff();
    public void updateStaff(int staffId,Staff staff);
    public void deleteStaff(int staffId);

    public void addFileByStaffId(int staffId,String filePath);


    public void addImageByStaffId(int staffId,String filePath);

    public String getEmergencyContactNumber(String name);
}
