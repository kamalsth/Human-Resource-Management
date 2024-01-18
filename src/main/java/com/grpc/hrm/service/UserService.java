package com.grpc.hrm.service;

import com.grpc.hrm.config.JwtTokenResponse;
import com.grpc.hrm.model.LoginModel;
import com.grpc.hrm.model.User;

public interface UserService {
    public void register(User user);
    public JwtTokenResponse login(LoginModel loginModel);
    public User getUserById(String userId);
    public void updateUser(String userId,User user);
    public void deleteUser(String userId);

}
