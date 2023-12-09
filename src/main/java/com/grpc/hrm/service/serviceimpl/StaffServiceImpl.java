package com.grpc.hrm.service.serviceimpl;

import com.grpc.hrm.entity.Staff;
import com.grpc.hrm.repository.StaffRepository;
import com.grpc.hrm.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff saveStaff(Staff staff) {
        String emergencyContactNumber = staffRepository.getEmergencyContactNumber(staff.getName());
        if(staff.getEmergencyContactNumber().equals(emergencyContactNumber)){
            throw new RuntimeException("User already exists with this Emergency contact number : " + staff.getEmergencyContactNumber());
        }
        return staffRepository.saveStaff(staff);
    }

    @Override
    public Staff getStaffById(int staffId) {
        Staff staff = staffRepository.getStaffById(staffId);
        if(staff == null){
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }
        return staffRepository.getStaffById(staffId);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    @Override
    public void updateStaff(int staffId, Staff staff) {
        Staff staff1 = staffRepository.getStaffById(staffId);
        if(staff1 == null){
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }
        staffRepository.updateStaff(staffId, staff);
    }

    @Override
    public void deleteStaff(int staffId) {
        Staff staff = staffRepository.getStaffById(staffId);
        if(staff == null){
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }
        staffRepository.deleteStaff(staffId);
    }

    @Override
    public void addFileByStaffId(int staffId, String filePath) {
        Staff staff = staffRepository.getStaffById(staffId);
        if(staff == null){
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }
        staffRepository.addFileByStaffId(staffId, filePath);
    }

    @Override
    public void addImageByStaffId(int staffId, String filePath) {
        Staff staff = staffRepository.getStaffById(staffId);
        if(staff == null){
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }
        staffRepository.addImageByStaffId(staffId, filePath);
    }
}
