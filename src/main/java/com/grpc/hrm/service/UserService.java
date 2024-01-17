package com.grpc.hrm.service;

import com.grpc.hrm.config.JwtTokenResponse;
import com.grpc.hrm.dto.LoginDto;
import com.grpc.hrm.model.User;

public interface UserService {
    public void register(User user);
    public JwtTokenResponse login(LoginDto loginDto);
    public User getUserById(String userId);
    public void updateUser(String userId,User user);
    public void deleteUser(String userId);

}
