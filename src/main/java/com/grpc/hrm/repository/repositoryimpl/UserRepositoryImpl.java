package com.grpc.hrm.repository.repositoryimpl;

import com.grpc.hrm.entity.User;
import com.grpc.hrm.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final DataSource dataSource;

    public UserRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User addUser(User user) {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "INSERT INTO users (username, password, name, email, phone, role) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getName() + "', '" + user.getEmail() + "', '" + user.getPhone() + "', '" + user.getRole() + "')";
                statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                System.out.println("User saved successfully");
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setUserId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error executing the SQL query" + e.getMessage());
            }
        }catch (SQLException e) {
            System.out.println("Error connecting to the database" + e.getMessage());
        }
        return user;
    }

        @Override
        public User getUserById ( int userId){
            return null;
        }

        @Override
        public User getUserByUsername (String username){
            return null;
        }

        @Override
        public void updateUser ( int userId, User user){

        }

        @Override
        public void deleteUser ( int userId){

        }
    }
