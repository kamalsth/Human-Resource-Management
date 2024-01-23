package com.grpc.hrm.repository.repositoryimpl;

import com.grpc.hrm.model.Role;
import com.grpc.hrm.model.User;
import com.grpc.hrm.model.UserDetail;
import com.grpc.hrm.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

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
            String sql = "INSERT INTO users (user_id,username, password, name, email, phone, role) VALUES (?,?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, user.getUserId());
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getName());
                preparedStatement.setString(5, user.getEmail());
                preparedStatement.setString(6, user.getPhone());
                preparedStatement.setString(7, user.getRole().name());

                preparedStatement.executeUpdate();

                logger.info("User saved successfully");

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setUserId(generatedKeys.getString(1));
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
    public User getUserById(String userId) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM users WHERE user_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapToUser(resultSet);
                    }
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
            String sql = "SELECT * FROM users WHERE username = ? or email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapToUser(resultSet);
                    }
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
    public void updateUser(String userId, User user) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "UPDATE users SET username = ?, password = ?, name = ?, email = ?, phone = ?, role = ? WHERE user_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getName());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPhone());
                preparedStatement.setString(6, user.getRole().name());
                preparedStatement.setString(7, userId);

                preparedStatement.executeUpdate();

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
    public void deleteUser(String userId) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "DELETE FROM users WHERE user_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, userId);

                preparedStatement.executeUpdate();

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
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT role FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("role");
                    }
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
    public User getUserByEmail(String email) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM users WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapToUser(resultSet);
                    }
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
    public UserDetail getUserByUserDetail(String username) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT user_id, username, name, email, phone, role FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String userId = resultSet.getString("user_id");
                        String username1 = resultSet.getString("username");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        String phone = resultSet.getString("phone");
                        Role role = Role.valueOf(resultSet.getString("role"));
                        return new UserDetail(userId, username1, name, email, phone, role);
                    }
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
        String userId = resultSet.getString("user_id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");
        Role role = Role.valueOf(resultSet.getString("role"));
        return new User(userId, username, password, name, email, phone, role);
    }
}
