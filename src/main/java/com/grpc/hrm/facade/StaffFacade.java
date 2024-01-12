package com.grpc.hrm.facade;

import com.grpc.hrm.config.MapperConfig;
import com.grpc.hrm.model.Staff;
import com.grpc.hrm.service.StaffService;
import com.ks.proto.staff.StaffResponse;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffFacade {
    private final StaffService staffService;


    public StaffFacade(StaffService staffService) {
        this.staffService = staffService;
    }

    public StaffResponse saveStaff(com.ks.proto.staff.Staff staff){
        validateStaff(staff);
        Staff staff1= MapperConfig.INSTANCE.mapToStaff(staff);
        return MapperConfig.INSTANCE.mapToProto(staffService.saveStaff(staff1));
    }

    public StaffResponse getStaffById(int staffId){
        return MapperConfig.INSTANCE.mapToProto(staffService.getStaffById(staffId));
    }

    public List<com.ks.proto.staff.Staff> getAllStaff() {
        List<Staff> staffs = staffService.getAllStaff();
        return staffs.stream().map(MapperConfig.INSTANCE::mapToListProto).toList();
    }

    public StaffResponse updateStaff(int staffId, com.ks.proto.staff.Staff staff){
        Staff staff1= MapperConfig.INSTANCE.mapToStaff(staff);
        staffService.updateStaff(staffId,staff1);
        return MapperConfig.INSTANCE.mapToProto(staff1);
    }

    public void deleteStaff(int staffId){
        staffService.deleteStaff(staffId);
    }

    public void addFileByStaffId(int staffId,String filePath){
        staffService.addFileByStaffId(staffId,filePath);
    }

    public void addImageByStaffId(int staffId,String filePath){
        staffService.addImageByStaffId(staffId,filePath);
    }


    public void validateStaff(com.ks.proto.staff.Staff staff){
        if(staff.getName().isEmpty() || staff.getPersonalPhone().isEmpty() || staff.getEmergencyContactNumber().isEmpty() || staff.getPosition().isEmpty() || staff.getJoinDate().isEmpty()){
            throw new IllegalArgumentException("Fields should not be empty");
        }
    }

}
