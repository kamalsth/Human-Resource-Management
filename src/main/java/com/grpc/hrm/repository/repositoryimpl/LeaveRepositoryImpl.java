package com.grpc.hrm.repository.repositoryimpl;

import com.grpc.hrm.model.LeaveRequestModel;
import com.grpc.hrm.model.LeaveStatus;
import com.grpc.hrm.repository.LeaveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class LeaveRepositoryImpl implements LeaveRepository {
    private final DataSource dataSource;

    private final Logger logger = LoggerFactory.getLogger(LeaveRepositoryImpl.class);


    public LeaveRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public LeaveRequestModel leaveRequest(LeaveRequestModel leaveRequestModel) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "INSERT INTO leave_request (id, `from`, `to`, subject, `status`, user_id) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, leaveRequestModel.getId());
                preparedStatement.setLong(2, leaveRequestModel.getFrom());
                preparedStatement.setLong(3, leaveRequestModel.getTo());
                preparedStatement.setString(4, leaveRequestModel.getSubject());
                preparedStatement.setString(5, leaveRequestModel.getStatus().name());
                preparedStatement.setString(6, leaveRequestModel.getUserId());

                preparedStatement.executeUpdate();

                logger.info("Leave request saved successfully");

            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());

            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return leaveRequestModel;
    }

    @Override
    public List<LeaveRequestModel> getAllLeaveRequest(int pageNumber, int pageSize) {
        List<LeaveRequestModel> leaveRequestModelList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM leave_request LIMIT ?, ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, pageNumber * pageSize);
                preparedStatement.setInt(2, pageSize);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        leaveRequestModelList.add(mapToLeaveRequestModel(resultSet));
                    }
                    logger.info("Leave request fetched successfully");

                } catch (SQLException e) {
                    logger.error("Error executing the SQL query" + e.getMessage());
                    throw new SQLException("Error executing the SQL query" + e.getMessage());
                }
            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return leaveRequestModelList;
    }

    @Override
    public LeaveRequestModel getLeaveRequestById(String id) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM leave_request WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        logger.info("Leave request fetched successfully");
                        return mapToLeaveRequestModel(resultSet);
                    }
                } catch (SQLException e) {
                    logger.error("Error executing the SQL query" + e.getMessage());
                    throw new SQLException("Error executing the SQL query" + e.getMessage());
                }
            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateLeaveRequest(String id, LeaveRequestModel leaveRequestModel) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "UPDATE leave_request SET `from` = ?, `to` = ?, subject = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, leaveRequestModel.getFrom());
                preparedStatement.setLong(2, leaveRequestModel.getTo());
                preparedStatement.setString(3, leaveRequestModel.getSubject());
                preparedStatement.setString(4, id);

                preparedStatement.executeUpdate();

                logger.info("Leave request updated successfully");

            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public void deleteLeaveRequest(String id) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "DELETE FROM leave_request WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, id);

                preparedStatement.executeUpdate();

                logger.info("Leave request deleted successfully");

            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public LeaveStatus confirmLeaveRequest(LeaveRequestModel leaveRequestModel) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "UPDATE leave_request SET `status` = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, leaveRequestModel.getStatus().name());
                preparedStatement.setString(2, leaveRequestModel.getId());

                preparedStatement.executeUpdate();

                logger.info("Leave request confirmed successfully");
                return leaveRequestModel.getStatus();
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return null;
    }

    @Override
    public String getUserIdFromUsername(String username) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT user_id FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        logger.info("User id fetched successfully");
                        return resultSet.getString("user_id");
                    }
                } catch (SQLException e) {
                    logger.error("Error executing the SQL query" + e.getMessage());
                    throw new SQLException("Error executing the SQL query" + e.getMessage());
                }
            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LeaveRequestModel> getLeaveRequestListByUser(String userId, int pageNumber, int pageSize) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM leave_request WHERE user_id = ? LIMIT ?, ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, userId);
                preparedStatement.setInt(2, pageNumber * pageSize);
                preparedStatement.setInt(3, pageSize);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<LeaveRequestModel> leaveRequestModelList = new ArrayList<>();
                    while (resultSet.next()) {
                        leaveRequestModelList.add(mapToLeaveRequestModel(resultSet));
                    }
                    logger.info("Leave request fetched successfully");
                    return leaveRequestModelList;
                } catch (SQLException e) {
                    logger.error("Error executing the SQL query" + e.getMessage());
                    throw new SQLException("Error executing the SQL query" + e.getMessage());
                }
            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return null;
    }

    @Override
    public LeaveRequestModel getLeaveRequestByUserId(String userId) {
        try(Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM leave_request WHERE user_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        logger.info("Leave request fetched successfully");
                        return mapToLeaveRequestModel(resultSet);
                    }
                } catch (SQLException e) {
                    logger.error("Error executing the SQL query" + e.getMessage());
                    throw new SQLException("Error executing the SQL query" + e.getMessage());
                }
            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return null;
    }


    private LeaveRequestModel mapToLeaveRequestModel(ResultSet resultSet) throws SQLException {
        return new LeaveRequestModel(
                resultSet.getString("id"),
                resultSet.getLong("from"),
                resultSet.getLong("to"),
                resultSet.getString("subject"),
                LeaveStatus.valueOf(resultSet.getString("status")),
                resultSet.getString("user_id"));
    }
}
