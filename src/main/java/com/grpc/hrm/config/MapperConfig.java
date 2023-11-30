package com.grpc.hrm.config;


import com.grpc.hrm.entity.Staff;
import generatedClasses.StaffListResponseOuterClass;
import generatedClasses.StaffOuterClass;
import generatedClasses.StaffResponseOuterClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface MapperConfig {
    MapperConfig INSTANCE = Mappers.getMapper(MapperConfig.class);
    Staff mapToStaff(StaffOuterClass.Staff staff);

//    @Mapping(target = "staffId", source = "staff.staffId")
    StaffResponseOuterClass.StaffResponse mapToProto(Staff staff);

    StaffOuterClass.Staff mapToListProto(Staff staff);

}
