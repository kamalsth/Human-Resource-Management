package com.grpc.hrm.utils;

import com.ks.proto.user.ChangePasswordRequest;

public class ValidateUser {


    public static void validationToChangePassword(ChangePasswordRequest request) {
        if (request.getOldPassword().isEmpty()) {
            throw new IllegalArgumentException("Old password field should not be empty");
        } else if (request.getNewPassword().isEmpty()) {
            throw new IllegalArgumentException("New password field should not be empty");
        }
    }
}
