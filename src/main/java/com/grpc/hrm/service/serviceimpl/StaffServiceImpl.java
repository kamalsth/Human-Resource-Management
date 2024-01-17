package com.grpc.hrm.service.serviceimpl;

import com.grpc.hrm.model.Staff;
import com.grpc.hrm.model.User;
import com.grpc.hrm.repository.StaffRepository;
import com.grpc.hrm.repository.UserRepository;
import com.grpc.hrm.service.StaffService;
import com.grpc.hrm.utils.GenerateUUID;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final UserRepository userRepository;

    public StaffServiceImpl(StaffRepository staffRepository, UserRepository userRepository) {
        this.staffRepository = staffRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Staff saveStaff(Staff staff) {
        String emergencyContactNumber = staffRepository.getEmergencyContactNumber(staff.getName());
        if (staff.getEmergencyContactNumber().equals(emergencyContactNumber)) {
            throw new RuntimeException("User already exists with this Emergency contact number : " + staff.getEmergencyContactNumber());
        }
        staff.setStaffId(GenerateUUID.generateID());
        User user = userRepository.getUserByEmail(staff.getEmail());
        if (user == null) {
            staff.setUserId(null);
        }
        assert user != null;
        staff.setUserId(user.getUserId());

        return staffRepository.saveStaff(staff);
    }

    @Override
    public Staff getStaffById(String staffId) {
        Staff staff = staffRepository.getStaffById(staffId);
        if (staff == null) {
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }
        return staffRepository.getStaffById(staffId);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    @Override
    public Staff updateStaff(String staffId, Staff staff) {
        Staff staff1 = staffRepository.getStaffById(staffId);
        if (staff1 == null) {
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }
        return staffRepository.updateStaff(staffId, staff);
    }

    @Override
    public void deleteStaff(String staffId) {
        Staff staff = staffRepository.getStaffById(staffId);
        if (staff == null) {
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }
        staffRepository.deleteStaff(staffId);
    }

    @Override
    public void addFileByStaffId(String staffId, String filePath) {
        Staff staff = staffRepository.getStaffById(staffId);
        if (staff == null) {
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }
        staffRepository.addFileByStaffId(staffId, filePath);
    }

    @Override
    public void addImageByStaffId(String staffId, String filePath) {
        Staff staff = staffRepository.getStaffById(staffId);
        if (staff == null) {
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }
        staffRepository.addImageByStaffId(staffId, filePath);
    }

    @Override
    public double taxCalculation(String staffId) {
        Staff staff = staffRepository.getStaffById(staffId);
        if (staff == null) {
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }
        return taxCalculationPerYear(staff);

    }

    public double taxCalculationPerYear(Staff staff) {
        double totalSalary = staff.getSalary() * 12;
        double tax = 0.0;

        if (totalSalary <= 500000) {
            tax = totalSalary * 0.01;
        } else if (totalSalary <= 700000) {
            // 5,00,000 * 0.01 + (totalSalary - 5,00,000) * 0.1
            tax = 5000 + (totalSalary - 500000) * 0.1;
        } else if (totalSalary <= 1000000) {
            // 5,00,000 * 0.01 + 2,00,000 * 0.1 + (totalSalary - 7,00,000) * 0.2
            tax = 5000 + 20000 + (totalSalary - 700000) * 0.2;
        } else if (totalSalary <= 2000000) {
            // 5,00,000 * 0.01 + 2,00,000 * 0.1 + 3,00,000 * 0.2 + (totalSalary - 10,00,000) * 0.3
            tax = 5000 + 20000 + 60000 + (totalSalary - 1000000) * 0.3;
        } else {
            // 5,00,000 * 0.01 + 2,00,000 * 0.1 + 3,00,000 * 0.2 + 10,00,000 * 0.3 + (totalSalary - 20,00,000) * 0.36
            tax = 5000 + 20000 + 60000 + 300000 + (totalSalary - 2000000) * 0.36;
        }
        return tax;
    }

}
