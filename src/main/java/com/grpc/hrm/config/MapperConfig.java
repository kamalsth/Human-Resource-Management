package com.grpc.hrm.config;


import com.grpc.hrm.dto.LoginDto;
import com.grpc.hrm.entity.Staff;
import com.grpc.hrm.entity.User;
import generatedClasses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper
public interface MapperConfig {
    MapperConfig INSTANCE = Mappers.getMapper(MapperConfig.class);
    Staff mapToStaff(StaffOuterClass.Staff staff);

//    @Mapping(target = "staffId", source = "staff.staffId")
    StaffResponseOuterClass.StaffResponse mapToProto(Staff staff);

    StaffOuterClass.Staff mapToListProto(Staff staff);


    @Mapping(source = "role", target = "role", qualifiedByName = "mapRoleToString")
    User mapToUser(UserOuterClass.User user);

    @Named("mapRoleToString")
    default String mapRoleToString(UserOuterClass.UserRole role) {
        return role.name();
    }

    @Mapping(source = "role", target = "role", qualifiedByName = "mapStringToRole")
    UserOuterClass.User mapToUserProto(User user);
    
    @Named("mapStringToRole")
    default UserOuterClass.UserRole mapStringToRole(String role) {
        return UserOuterClass.UserRole.valueOf(role);
    }

    LoginDto mapToLoginDto(LoginRequestOuterClass.LoginRequest loginRequest);
}
