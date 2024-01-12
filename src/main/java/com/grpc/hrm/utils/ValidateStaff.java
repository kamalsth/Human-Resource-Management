package com.grpc.hrm.utils;

public class ValidateStaff {

    public static void validateStaff(com.ks.proto.staff.Staff staff){
        if(staff.getName().isEmpty() || staff.getPersonalPhone().isEmpty() || staff.getEmergencyContactNumber().isEmpty() || staff.getPosition().isEmpty() || staff.getJoinDate().isEmpty()){
            throw new IllegalArgumentException("Fields should not be empty");
        }
    }


}
