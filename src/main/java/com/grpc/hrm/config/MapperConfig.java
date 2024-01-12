package com.grpc.hrm.config;


import com.grpc.hrm.dto.LoginDto;
import com.grpc.hrm.entity.Staff;
import com.grpc.hrm.entity.User;
import com.ks.proto.auth.LoginRequest;
import com.ks.proto.staff.StaffResponse;
import com.ks.proto.user.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper
public interface MapperConfig {
    MapperConfig INSTANCE = Mappers.getMapper(MapperConfig.class);
    Staff mapToStaff(com.ks.proto.staff.Staff staff);

//    @Mapping(target = "staffId", source = "staff.staffId")
    StaffResponse mapToProto(Staff staff);

   com.ks.proto.staff.Staff mapToListProto(Staff staff);


    @Mapping(source = "role", target = "role", qualifiedByName = "mapRoleToString")
    User mapToUser(com.ks.proto.user.User user);

    @Named("mapRoleToString")
    default String mapRoleToString(UserRole role) {
        return role.name();
    }

    @Mapping(source = "role", target = "role", qualifiedByName = "mapStringToRole")
    com.ks.proto.user.User mapToUserProto(User user);
    
    @Named("mapStringToRole")
    default UserRole mapStringToRole(String role) {
        return UserRole.valueOf(role);
    }

    LoginDto mapToLoginDto(LoginRequest loginRequest);
}
