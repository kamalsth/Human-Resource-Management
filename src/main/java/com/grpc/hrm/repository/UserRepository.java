package com.grpc.hrm.repository;

import com.grpc.hrm.entity.User;

public interface UserRepository {

    public User addUser(User user);
    public User getUserById(int userId);
    public User getUserByUsername(String username);
    public void updateUser(int userId,User user);
    public void deleteUser(int userId);

}
