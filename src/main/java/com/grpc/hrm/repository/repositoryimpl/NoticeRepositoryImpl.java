package com.grpc.hrm.repository.repositoryimpl;

import com.grpc.hrm.model.Notice;
import com.grpc.hrm.repository.NoticeRepository;
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
public class NoticeRepositoryImpl implements NoticeRepository {


    private final DataSource dataSource;

    private final Logger logger = LoggerFactory.getLogger(NoticeRepositoryImpl.class);

    public NoticeRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Notice addNotice(Notice notice) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connection established");
            String sql = "INSERT INTO notice (notice_id, title, content, created_at, updated_at) VALUES (?, ?, ?, ?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, notice.getNoticeId());
                preparedStatement.setString(2, notice.getTitle());
                preparedStatement.setString(3, notice.getContent());
                preparedStatement.setLong(4, notice.getCreatedAt());
                preparedStatement.setLong(5, notice.getUpdatedAt());
                preparedStatement.executeUpdate();
                logger.info("Notice added successfully ");
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());

            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return notice;
    }


    @Override
    public List<Notice> getAllNotice(int pageNumber, int pageSize) {
        List<Notice> noticeList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connection established");
            String sql = "SELECT * FROM notice LIMIT ? OFFSET ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, pageSize);
                preparedStatement.setInt(2, pageNumber);
                try (var resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        noticeList.add(mapToNotice(resultSet));
                    }
                    logger.info("Notice added successfully ");
                } catch (SQLException e) {
                    logger.error("Error executing the SQL query" + e.getMessage());
                    throw new SQLException("Error executing the SQL query" + e.getMessage());

                }
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());

            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return noticeList;
    }

    @Override
    public Notice updateNotice(String noticeId, Notice notice) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connection established");
            String sql = "UPDATE notice SET title = ?, content = ? , updated_at=? WHERE notice_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, notice.getTitle());
                preparedStatement.setString(2, notice.getContent());
                preparedStatement.setLong(3, notice.getUpdatedAt());
                preparedStatement.setString(4, noticeId);
                int rowsUpdated = preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    logger.info("Notice updated successfully ");
                    return getNoticeById(noticeId);
                } else {
                    throw new SQLException("Error updating the notice" + noticeId);
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
    public Notice getNoticeById(String noticeId) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connection established");
            String sql = "SELECT * FROM notice WHERE notice_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, noticeId);
                try (var resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapToNotice(resultSet);
                    }
                    logger.info("Notice added successfully ");
                } catch (SQLException e) {
                    logger.error("Error executing the SQL query" + e.getMessage());
                    throw new SQLException("Error executing the SQL query" + e.getMessage());

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
    public void deleteNotice(String noticeId) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connection established");
            String sql = "DELETE FROM notice WHERE notice_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, noticeId);
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    logger.info("Notice deleted successfully ");
                } else {
                    throw new SQLException("Error deleting the notice" + noticeId);
                }
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());

            }
        } catch (Exception e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
    }


    private Notice mapToNotice(ResultSet resultSet) throws SQLException {
        return new Notice(
                resultSet.getString("notice_id"),
                resultSet.getString("title"),
                resultSet.getString("content"),
                resultSet.getLong("created_at"),
                resultSet.getLong("updated_at")
        );
    }
}
