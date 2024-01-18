package com.grpc.hrm.repository;

import com.grpc.hrm.model.User;

public interface UserRepository {

    public void register(User user);
    public User getUserById(String userId);
    public User getUserByUsername(String username);
    public void updateUser(String userId,User user);
    public void deleteUser(String userId);

    public String getRoleByUsername(String username);

    User getUserByEmail(String email);
}
