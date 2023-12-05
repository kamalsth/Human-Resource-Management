package com.grpc.hrm.repository.repositoryimpl;

import com.grpc.hrm.entity.Role;
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
    public void register(User user) {
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
        } catch (SQLException e) {
            System.out.println("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public User getUserById(int userId) {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM users WHERE user_id = " + userId;
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    return mapToUser(resultSet);
                }
            } catch (SQLException e) {
                System.out.println("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database" + e.getMessage());
        }
        return null;
    }


    @Override
    public User getUserByUsername(String username) {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM users WHERE username = '" + username + "'";
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    return mapToUser(resultSet);
                }
            } catch (SQLException e) {
                System.out.println("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database" + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateUser(int userId, User user) {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "UPDATE users SET username = '" + user.getUsername() + "', password = '" + user.getPassword() + "', name = '" + user.getName() + "', email = '" + user.getEmail() + "', phone = '" + user.getPhone() + "', role = '" + user.getRole() + "' WHERE user_id = " + userId;
                statement.executeUpdate(sql);
                System.out.println("User updated successfully");
            } catch (SQLException e) {
                System.out.println("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userId) {
        try(Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "DELETE FROM users WHERE user_id = " + userId;
                statement.executeUpdate(sql);
                System.out.println("User deleted successfully");
            } catch (SQLException e) {
                System.out.println("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public String getRoleByUsername(String username) {
        try(Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT role FROM users WHERE username = '" + username + "'";
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    return resultSet.getString("role");
                }
            } catch (SQLException e) {
                System.out.println("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database" + e.getMessage());
        }
        return null;
    }

    private User mapToUser(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("user_id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");
        Role role = Role.valueOf(resultSet.getString("role"));
        return new User(userId, username, password, name, email, phone, role);
    }
}
