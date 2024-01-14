package com.grpc.hrm.utils;

import com.ks.proto.auth.LoginRequest;

public class ValidateUserLogin {
    public static void validateUserLogin(LoginRequest loginRequest){
        if(loginRequest.getUsername().isEmpty() || loginRequest.getPassword().isEmpty()){
            throw new IllegalArgumentException("Fields should not be empty");
        }
    }
}
