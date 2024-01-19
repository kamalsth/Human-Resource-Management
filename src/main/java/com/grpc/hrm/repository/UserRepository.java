package com.grpc.hrm.repository;

import com.grpc.hrm.model.User;

public interface UserRepository {

    void register(User user);

    User getUserById(String userId);

    User getUserByUsername(String username);

    void updateUser(String userId, User user);

    void deleteUser(String userId);

    String getRoleByUsername(String username);

    User getUserByEmail(String email);
}
