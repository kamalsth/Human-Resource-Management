package com.grpc.hrm.repository.repositoryimpl;

import com.grpc.hrm.model.LeaveRequestModel;
import com.grpc.hrm.model.LeaveStatus;
import com.grpc.hrm.repository.LeaveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            try (Statement statement = connection.createStatement()) {
                String sql = "INSERT INTO leave_request ( id, `from`, `to`, subject, `status`, user_id) VALUES ('" + leaveRequestModel.getId() + "', '" + leaveRequestModel.getFrom() + "', '" + leaveRequestModel.getTo() + "', '" + leaveRequestModel.getSubject() + "', '" + leaveRequestModel.getStatus() + "', '" + leaveRequestModel.getUserId() + "' )";
                statement.executeUpdate(sql);
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
    public List<LeaveRequestModel> getAllLeaveRequest() {
        List<LeaveRequestModel> leaveRequestModelList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM leave_request";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    leaveRequestModelList.add(mapToLeaveRequestModel(resultSet));
                }
                logger.info("Leave request fetched successfully");

            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());

            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return leaveRequestModelList;
    }


    private LeaveRequestModel mapToLeaveRequestModel(ResultSet resultSet) throws SQLException {
        return new LeaveRequestModel(
                resultSet.getString("id"),
                resultSet.getString("from"),
                resultSet.getString("to"),
                resultSet.getString("subject"),
                LeaveStatus.valueOf(resultSet.getString("status")),
                resultSet.getInt("user_id"));
    }

    @Override
    public LeaveRequestModel getLeaveRequestById(String id) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM leave_request WHERE id = '" + id + "'";
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    logger.info("Leave request fetched successfully");
                    return mapToLeaveRequestModel(resultSet);
                }

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
    public void updateLeaveRequest(String id, LeaveRequestModel leaveRequestModel) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "UPDATE leave_request SET `from` = '" + leaveRequestModel.getFrom() + "', `to` = '" + leaveRequestModel.getTo() + "', subject = '" + leaveRequestModel.getSubject() + "' WHERE id = '" + id + "'";
                statement.executeUpdate(sql);
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
            try (Statement statement = connection.createStatement()) {
                String sql = "DELETE FROM leave_request WHERE id = '" + id + "'";
                statement.executeUpdate(sql);
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
    public void confirmLeaveRequest(LeaveRequestModel leaveRequestModel) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "UPDATE leave_request SET `status` = '" + leaveRequestModel.getStatus().name() + "' WHERE id = '" + leaveRequestModel.getId() + "'";
                statement.executeUpdate(sql);
                logger.info("Leave request confirmed successfully");

            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());

            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public int getUserIdFromUsername(String username) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT user_id FROM users WHERE username = '" + username + "'";
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    return resultSet.getInt("user_id");
                }
                logger.info("User id fetched successfully");

            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());

            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return 0;
    }
}
