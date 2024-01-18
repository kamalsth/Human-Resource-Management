package com.grpc.hrm.facade;

import com.grpc.hrm.config.MapperConfig;
import com.grpc.hrm.model.Staff;
import com.grpc.hrm.service.StaffService;
import com.grpc.hrm.utils.ValidateStaff;
import com.ks.proto.staff.StaffResponse;
import com.ks.proto.staff.TaxCalResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffFacade {
    private final StaffService staffService;


    public StaffFacade(StaffService staffService) {
        this.staffService = staffService;
    }

    public StaffResponse saveStaff(com.ks.proto.staff.Staff staff){
        ValidateStaff.validateStaff(staff);
        Staff staff1= MapperConfig.INSTANCE.mapToStaff(staff);
        return MapperConfig.INSTANCE.mapToProto(staffService.saveStaff(staff1));
    }

    public StaffResponse getStaffById(String staffId){
        return MapperConfig.INSTANCE.mapToProto(staffService.getStaffById(staffId));
    }

    public List<com.ks.proto.staff.Staff> getAllStaff() {
        List<Staff> staffs = staffService.getAllStaff();
        return staffs.stream().map(MapperConfig.INSTANCE::mapToListProto).toList();
    }

    public StaffResponse updateStaff(String staffId, com.ks.proto.staff.Staff staff){
        Staff staff1= MapperConfig.INSTANCE.mapToStaff(staff);
        return MapperConfig.INSTANCE.mapToProto(staffService.updateStaff(staffId,staff1));
    }

    public void deleteStaff(String staffId){
        staffService.deleteStaff(staffId);
    }

    public void addFileByStaffId(String staffId,String filePath){
        staffService.addFileByStaffId(staffId,filePath);
    }

    public void addImageByStaffId(String staffId,String filePath){
        staffService.addImageByStaffId(staffId,filePath);
    }


    public double taxCalculation(String staffId) {
        return staffService.taxCalculation(staffId);
    }

    public TaxCalResponse calculateTax(String staffId) {

        return MapperConfig.INSTANCE.mapToProtoTax(staffService.calculateTax(staffId));
    }
}
