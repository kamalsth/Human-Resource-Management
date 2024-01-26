package com.grpc.hrm.facade;

import com.grpc.hrm.mapper.MapperConfig;
import com.grpc.hrm.model.Staff;
import com.grpc.hrm.service.StaffService;
import com.grpc.hrm.utils.ValidateStaff;
import com.ks.proto.common.StatusResponse;
import com.ks.proto.staff.FileUploadResponse;
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

    public StaffResponse saveStaff(com.ks.proto.staff.Staff staff) {
        ValidateStaff.validateStaff(staff);
        Staff staff1 = MapperConfig.INSTANCE.mapToStaff(staff);
        return MapperConfig.INSTANCE.mapToProto(staffService.saveStaff(staff1));
    }

    public StaffResponse getStaffById(String staffId) {
        ValidateStaff.validateId(staffId);
        return MapperConfig.INSTANCE.mapToProto(staffService.getStaffById(staffId));
    }

    public List<com.ks.proto.staff.Staff> getAllStaff(int pageNumber, int pageSize) {
        List<Staff> staffs = staffService.getAllStaff(pageNumber, pageSize);
        return staffs.stream().map(MapperConfig.INSTANCE::mapToListProto).toList();
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
