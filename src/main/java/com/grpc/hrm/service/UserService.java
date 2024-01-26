package com.grpc.hrm.service;

import com.grpc.hrm.jwt.JwtTokenResponse;
import com.grpc.hrm.model.ChangePassword;
import com.grpc.hrm.model.LoginModel;
import com.grpc.hrm.model.User;
import com.grpc.hrm.model.UserDetail;

public interface UserService {
    String register(User user);

    JwtTokenResponse login(LoginModel loginModel);

    User getUserById(String userId);

    void updateUser(String userId, User user);

    void deleteUser(String userId);

    UserDetail aboutMe();


    String changePassword(ChangePassword changePassword);
}
