package com.grpc.hrm.repository.repositoryimpl;

import com.grpc.hrm.model.Role;
import com.grpc.hrm.model.User;
import com.grpc.hrm.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final DataSource dataSource;

    private final Logger logger= LoggerFactory.getLogger(UserRepositoryImpl.class);
    public UserRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void register(User user) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "INSERT INTO users (username, password, name, email, phone, role) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getName() + "', '" + user.getEmail() + "', '" + user.getPhone() + "', '" + user.getRole() + "')";
                statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                logger.info("User saved successfully");
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setUserId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public User getUserById(int userId) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM users WHERE user_id = " + userId;
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    return mapToUser(resultSet);
                }
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return null;
    }


    @Override
    public User getUserByUsername(String username) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM users WHERE username = '" + username + "'";
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    return mapToUser(resultSet);
                }
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateUser(int userId, User user) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "UPDATE users SET username = '" + user.getUsername() + "', password = '" + user.getPassword() + "', name = '" + user.getName() + "', email = '" + user.getEmail() + "', phone = '" + user.getPhone() + "', role = '" + user.getRole() + "' WHERE user_id = " + userId;
                statement.executeUpdate(sql);
                logger.info("User updated successfully");
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userId) {
        try(Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "DELETE FROM users WHERE user_id = " + userId;
                statement.executeUpdate(sql);
                logger.info("User deleted successfully");
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public String getRoleByUsername(String username) {
        try(Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT role FROM users WHERE username = '" + username + "'";
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    return resultSet.getString("role");
                }
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());
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
