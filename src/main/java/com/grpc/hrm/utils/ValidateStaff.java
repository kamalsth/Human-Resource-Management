package com.grpc.hrm.utils;

public class ValidateStaff {

    public static void validateStaff(com.ks.proto.staff.Staff staff){
        if(staff.getName().isEmpty() || staff.getPersonalPhone().isEmpty() || staff.getEmergencyContactNumber().isEmpty() || staff.getPosition().isEmpty() || staff.getJoinDate()==0  || staff.getSalary()==0 || staff.getMaritalStatus().toString().isEmpty() || staff.getEmail().isEmpty()){
            throw new IllegalArgumentException("Fields should not be empty");
        }
    }


    public static void validateId(String staffId) {
        if(staffId.isEmpty()){
            throw new IllegalArgumentException("staffId should not be empty");
        }
    }
}
