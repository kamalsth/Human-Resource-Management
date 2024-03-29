package com.grpc.hrm.utils;

import com.ks.proto.auth.LoginRequest;
import com.ks.proto.user.ChangePasswordRequest;
import com.ks.proto.user.User;

public class ValidateUser {


    public static void validationToChangePassword(ChangePasswordRequest request) {
        if (request.getOldPassword().isEmpty()) {
            throw new IllegalArgumentException("Old password field should not be empty");
        } else if (request.getNewPassword().isEmpty()) {
            throw new IllegalArgumentException("New password field should not be empty");
        }
    }


    public static void validateUserLogin(LoginRequest loginRequest){
        if(loginRequest.getUsername().isEmpty() || loginRequest.getPassword().isEmpty()){
            throw new IllegalArgumentException("Fields should not be empty");
        }
    }

    public static void validateUsersForRegister(User user){
        if(user==null){
            throw new NullPointerException("User is null");
        }
        if(user.getUsername().isEmpty() || user.getName().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty() || user.getPhone().isEmpty()) {
            throw new IllegalArgumentException("Fields should not be empty");
        }

    }


//    public static boolean validateEmail(String email) {
//        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
//        return email.matches(emailRegex);
//    }
//
//    public static boolean validatePassword(String password) {
//        String passwordRegex = "^(?=.*[0-9])"
//                + "(?=.*[a-z])(?=.*[A-Z])"
//                + "(?=.*[@#$%^&+=])"
//                + "(?=\\S+$).{8,20}$";
//        return password.matches(passwordRegex);
//    }
}
