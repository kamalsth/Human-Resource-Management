package com.grpc.hrm.service.serviceimpl;

import com.grpc.hrm.model.MaritalStatus;
import com.grpc.hrm.model.Staff;
import com.grpc.hrm.repository.StaffRepository;
import com.grpc.hrm.service.StaffService;
import com.grpc.hrm.utils.GenerateUUID;
import com.grpc.hrm.utils.TaxCalculation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }


    @Override
    public Staff saveStaff(Staff staff) {
        Staff existingStaffWithEmail = staffRepository.getStaffByEmail(staff.getEmail());
        if (existingStaffWithEmail != null) {
            throw new RuntimeException("Staff already exists with this email : " + staff.getEmail());
        }

        Staff existingStaff = staffRepository.getStaffByEmergencyContactNumber(staff.getEmergencyContactNumber());
        if (existingStaff != null) {
            throw new RuntimeException("Staff already exists with this emergency contact number : " + staff.getEmergencyContactNumber());
        }

        staff.setStaffId(GenerateUUID.generateID());

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
    public List<Staff> getAllStaff(int pageNumber, int pageSize) {
        return staffRepository.getAllStaff(pageNumber, pageSize);
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
    public com.grpc.hrm.model.TaxCalculation calculateTax(String staffId) {
        Staff staff = staffRepository.getStaffById(staffId);

        if (staff == null) {
            throw new RuntimeException("Staff not found for staff id : " + staffId);
        }

        double tax = 0.0;
        double totalSalary = staff.getSalary() * 12;
        double[] deductions = {
                staff.getSocialSecurityFund() * 12,
                staff.getEmployeesProvidentFund() * 12,
                staff.getCitizenInvestmentTrust() * 12,
                staff.getInsurance() * 12
        };
        double totalDeduction = Arrays.stream(deductions).sum();

        if (staff.getMaritalStatus().equals(MaritalStatus.UNMARRIED)) {
            tax = TaxCalculation.calculateTaxForUnmarried(totalSalary, totalDeduction);

        } else {
            tax = TaxCalculation.calculateTaxForMarried(totalSalary, totalDeduction);
        }

        return new com.grpc.hrm.model.TaxCalculation(staff.getName(),
                staff.getMaritalStatus().name(),
                staff.getSalary(),
                totalSalary,
                tax);
    }


}
