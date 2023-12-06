package com.grpc.hrm.service;

import com.grpc.hrm.config.JwtTokenResponse;
import com.grpc.hrm.dto.LoginDto;
import com.grpc.hrm.entity.User;

public interface UserService {
    public void register(User user);
    public JwtTokenResponse login(LoginDto loginDto);
    public User getUserById(int userId);
    public User getUserByUsername(String username);
    public void updateUser(int userId,User user);
    public void deleteUser(int userId);

}