package com.grpc.hrm.facade;

import com.grpc.hrm.config.MapperConfig;
import com.grpc.hrm.entity.Staff;
import com.grpc.hrm.service.StaffService;
import generatedClasses.StaffListResponseOuterClass;
import generatedClasses.StaffOuterClass;
import generatedClasses.StaffResponseOuterClass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffFacade {
    private final StaffService staffService;


    public StaffFacade(StaffService staffService) {
        this.staffService = staffService;
    }

    public StaffResponseOuterClass.StaffResponse saveStaff(StaffOuterClass.Staff staff){
        Staff staff1= MapperConfig.INSTANCE.mapToStaff(staff);
        return MapperConfig.INSTANCE.mapToProto(staffService.saveStaff(staff1));
    }

    public StaffResponseOuterClass.StaffResponse getStaffById(int staffId){
        return MapperConfig.INSTANCE.mapToProto(staffService.getStaffById(staffId));
    }

    public List<StaffOuterClass.Staff> getAllStaff() {
        List<Staff> staffs = staffService.getAllStaff();
        return staffs.stream().map(MapperConfig.INSTANCE::mapToListProto).toList();
    }

    public StaffResponseOuterClass.StaffResponse updateStaff(int staffId,StaffOuterClass.Staff staff){
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

}
