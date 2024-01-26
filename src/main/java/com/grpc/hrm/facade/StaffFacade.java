package com.grpc.hrm.facade;

import com.grpc.hrm.mapper.MapperConfig;
import com.grpc.hrm.model.Staff;
import com.grpc.hrm.service.StaffService;
import com.grpc.hrm.utils.ValidateStaff;
import com.ks.proto.common.StatusResponse;
import com.ks.proto.staff.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffFacade {
    private final StaffService staffService;


    public StaffFacade(StaffService staffService) {
        this.staffService = staffService;
    }

    public StaffResponse saveStaff(com.ks.proto.staff.Staff staff) {
        ValidateStaff.validateStaff(staff);
        Staff staff1 = MapperConfig.INSTANCE.mapToStaff(staff);
        return MapperConfig.INSTANCE.mapToProto(staffService.saveStaff(staff1));
    }

    public StaffResponse getStaffById(String staffId) {
        ValidateStaff.validateId(staffId);
        return MapperConfig.INSTANCE.mapToProto(staffService.getStaffById(staffId));
    }

    public StaffListResponse getAllStaff(StaffListRequest request) {
        List<Staff> staffs = staffService.getAllStaff(request.getPageNumber(), request.getPageSize());
        return StaffListResponse.newBuilder()
                .addAllStaffList(staffs.stream().map(MapperConfig.INSTANCE::mapToListProto).toList())
                .build();
    }

    public StaffResponse updateStaff(String staffId, com.ks.proto.staff.Staff staff) {
        ValidateStaff.validateId(staffId);
        ValidateStaff.validateStaff(staff);
        Staff staff1 = MapperConfig.INSTANCE.mapToStaff(staff);
        return MapperConfig.INSTANCE.mapToProto(staffService.updateStaff(staffId, staff1));
    }

    public StatusResponse deleteStaff(String staffId) {
        ValidateStaff.validateId(staffId);
        return StatusResponse.newBuilder()
                .setStatus(staffService.deleteStaff(staffId))
                .build();
    }

    public FileUploadResponse addFileByStaffId(String staffId, String filePath) {
        ValidateStaff.validateId(staffId);
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        return FileUploadResponse.newBuilder()
                .setFileName(fileName)
                .setUploadStatus(staffService.addFileByStaffId(staffId, filePath))
                .build();
    }

    public FileUploadResponse addImageByStaffId(String staffId, String filePath) {
        ValidateStaff.validateId(staffId);
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        return FileUploadResponse.newBuilder()
                .setFileName(fileName)
                .setUploadStatus(staffService.addImageByStaffId(staffId, filePath))
                .build();
    }


    public TaxCalResponse calculateTax(String staffId) {
        ValidateStaff.validateId(staffId);
        return MapperConfig.INSTANCE.mapToProtoTax(staffService.calculateTax(staffId));
    }
}
