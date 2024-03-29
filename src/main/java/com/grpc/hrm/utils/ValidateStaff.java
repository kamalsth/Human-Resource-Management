package com.grpc.hrm.utils;

public class ValidateStaff {

    public static void validateStaff(com.ks.proto.staff.Staff staff) {
        if (staff.getName().isEmpty()) {
            throw new IllegalArgumentException("Name should not be empty");

        } else if (staff.getPersonalPhone().isEmpty()) {
            throw new IllegalArgumentException("Personal Phone should not be empty");

        } else if (staff.getEmergencyContactNumber().isEmpty()) {
            throw new IllegalArgumentException("Emergency Contact Number should not be empty");

        } else if (staff.getPosition().isEmpty()) {
            throw new IllegalArgumentException("Position should not be empty");

        } else if (staff.getJoinDate() == 0) {
            throw new IllegalArgumentException("Join Date should not be empty");

        } else if (staff.getSalary() == 0) {
            throw new IllegalArgumentException("Salary should not be empty");

        } else if (staff.getMaritalStatus().toString().isEmpty()) {
            throw new IllegalArgumentException("Marital Status should not be empty");

        } else if (staff.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email should not be empty");

        }

    }


    public static void validateId(String staffId) {
        if (staffId.isEmpty()) {
            throw new IllegalArgumentException("staffId should not be empty");
        }
    }
}
