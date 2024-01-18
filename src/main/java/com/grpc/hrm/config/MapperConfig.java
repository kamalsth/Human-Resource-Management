package com.grpc.hrm.config;


import com.grpc.hrm.model.LoginModel;
import com.grpc.hrm.model.LeaveRequestModel;
import com.grpc.hrm.model.Staff;
import com.grpc.hrm.model.TaxCalculation;
import com.grpc.hrm.model.User;
import com.ks.proto.auth.LoginRequest;
import com.ks.proto.leave.*;
import com.ks.proto.staff.MaritalStatus;
import com.ks.proto.staff.StaffResponse;
import com.ks.proto.staff.TaxCalResponse;
import com.ks.proto.user.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper
public interface MapperConfig {
    MapperConfig INSTANCE = Mappers.getMapper(MapperConfig.class);

    @Mapping(source = "maritalStatus", target = "maritalStatus", qualifiedByName = "mapMaritalStatusToString")
    Staff mapToStaff(com.ks.proto.staff.Staff staff);

    @Named("mapMaritalStatusToString")
    default String mapMaritalStatusToString(MaritalStatus maritalStatus) {
        return maritalStatus.name();
    }

    @Mapping(source = "maritalStatus", target = "maritalStatus", qualifiedByName = "mapStringToMaritalStatus")
    StaffResponse mapToProto(Staff staff);

    @Named("mapStringToMaritalStatus")
    default MaritalStatus mapStringToMaritalStatus(String maritalStatus) {
        return MaritalStatus.valueOf(maritalStatus);
    }

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

    LoginModel mapToLoginDto(LoginRequest loginRequest);

    @Mapping(source = "leaveStatus", target = "status", qualifiedByName = "mapLeaveStatusToString")
    LeaveRequestModel mapTOLeaveRequestModel(LeaveRequest leaveRequest);

    @Named("mapLeaveStatusToString")
    default String mapLeaveStatusToString(LeaveStatus leaveStatus) {
        return leaveStatus.name();
    }

    @Mapping(source = "status", target = "leaveStatus", qualifiedByName = "mapStringToLeaveStatus")
    LeaveResponse mapToLeaveRequestProto(LeaveRequestModel leaveRequestModel);

    @Named("mapStringToLeaveStatus")
    default LeaveStatus mapStringToLeaveStatus(String leaveStatus) {
        return LeaveStatus.valueOf(leaveStatus);
    }

    LeaveResponse mapToLeaveListProto(LeaveRequestModel leaveRequestModel);


    @Mapping(source = "leaveStatus", target = "leaveStatus", qualifiedByName = "mapLeaveStatusToString")
    com.grpc.hrm.model.ConfirmLeaveRequest mapToConfirmLeaveRequest(ConfirmLeaveRequest request);


    TaxCalResponse mapToProtoTax(TaxCalculation taxCalculation);
}
