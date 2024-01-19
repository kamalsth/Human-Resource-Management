package com.grpc.hrm.service;

import com.grpc.hrm.config.JwtTokenResponse;
import com.grpc.hrm.model.LoginModel;
import com.grpc.hrm.model.User;

public interface UserService {
    void register(User user);

    JwtTokenResponse login(LoginModel loginModel);

    User getUserById(String userId);

    void updateUser(String userId, User user);

    void deleteUser(String userId);

}
