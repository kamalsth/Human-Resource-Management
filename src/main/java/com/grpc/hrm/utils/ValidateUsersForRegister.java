package com.grpc.hrm.utils;

import com.ks.proto.user.User;

public class ValidateUsersForRegister {

    public static void validateUsersForRegister(User user){
        if(user==null){
            throw new NullPointerException("User is null");
        }
        if(user.getUsername().isEmpty() || user.getName().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty() || user.getPhone().isEmpty()) {
            throw new IllegalArgumentException("Fields should not be empty");
        }

    }
}
