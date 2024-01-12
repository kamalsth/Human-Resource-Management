package com.grpc.hrm.repository;

import com.grpc.hrm.model.User;

public interface UserRepository {

    public void register(User user);
    public User getUserById(int userId);
    public User getUserByUsername(String username);
    public void updateUser(int userId,User user);
    public void deleteUser(int userId);

    public String getRoleByUsername(String username);

}
