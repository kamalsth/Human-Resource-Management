package com.grpc.hrm.service.serviceimpl;

import com.grpc.hrm.entity.Staff;
import com.grpc.hrm.repository.StaffRepository;
import com.grpc.hrm.service.StaffService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        return staffRepository.saveStaff(staff);
    }

    @Override
    public Staff getStaffById(int staffId) {
        return staffRepository.getStaffById(staffId);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    @Override
    public void updateStaff(int staffId, Staff staff) {
        staffRepository.updateStaff(staffId, staff);
    }

    @Override
    public void deleteStaff(int staffId) {
        staffRepository.deleteStaff(staffId);
    }
}
