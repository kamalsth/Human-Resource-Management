package com.grpc.hrm.repository.repositoryimpl;

import com.grpc.hrm.model.Staff;
import com.grpc.hrm.repository.StaffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StaffRepositoryImpl implements StaffRepository {

    private final DataSource dataSource;
    private final Logger logger = LoggerFactory.getLogger(StaffRepositoryImpl.class);

    public StaffRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Staff saveStaff(Staff staff) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "INSERT INTO staff (name, personal_phone, emergency_contact_number, position,citizenship_photo,contact_doc_pdf,join_date,contact_renew_date,salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, staff.getName());
                preparedStatement.setString(2, staff.getPersonalPhone());
                preparedStatement.setString(3, staff.getEmergencyContactNumber());
                preparedStatement.setString(4, staff.getPosition());
                preparedStatement.setString(5, staff.getCitizenshipPhoto());
                preparedStatement.setString(6, staff.getContactDocPdf());
                preparedStatement.setString(7, staff.getJoinDate());
                preparedStatement.setString(8, staff.getContactRenewDate());
                preparedStatement.setDouble(9, staff.getSalary());

                preparedStatement.executeUpdate();

                logger.info("Staff saved successfully");

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        staff.setStaffId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating staff failed, no ID obtained.");
                    }
                }
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());

            }
        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());

        }
        return staff;
    }

    @Override
    public Staff getStaffById(int staffId) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM staff WHERE staff_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, staffId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapToStaff(resultSet);
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
    public List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM staff";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        staffList.add(mapToStaff(resultSet));
                    }
                }
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }

        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
        return staffList;
    }

    @Override
    public void updateStaff(int staffId, Staff staff) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "UPDATE staff SET name = ?, personal_phone = ?, emergency_contact_number = ?, position = ?, citizenship_photo = ?, contact_doc_pdf = ?, join_date = ?, contact_renew_date = ?, salary = ? WHERE staff_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, staff.getName());
                preparedStatement.setString(2, staff.getPersonalPhone());
                preparedStatement.setString(3, staff.getEmergencyContactNumber());
                preparedStatement.setString(4, staff.getPosition());
                preparedStatement.setString(5, staff.getCitizenshipPhoto());
                preparedStatement.setString(6, staff.getContactDocPdf());
                preparedStatement.setString(7, staff.getJoinDate());
                preparedStatement.setString(8, staff.getContactRenewDate());
                preparedStatement.setDouble(9, staff.getSalary());
                preparedStatement.setInt(10, staffId);

                preparedStatement.executeUpdate();

                logger.info("Staff updated successfully");
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }

    }

    @Override
    public void deleteStaff(int staffId) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "DELETE FROM staff WHERE staff_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, staffId);

                preparedStatement.executeUpdate();

                logger.info("Staff deleted successfully");
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public void addFileByStaffId(int staffId, String filePath) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "UPDATE staff SET contact_doc_pdf = ? WHERE staff_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, filePath);
                preparedStatement.setInt(2, staffId);

                preparedStatement.executeUpdate();

                logger.info("File added successfully");
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public void addImageByStaffId(int staffId, String filePath) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "UPDATE staff SET citizenship_photo = ? WHERE staff_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, filePath);
                preparedStatement.setInt(2, staffId);

                preparedStatement.executeUpdate();

                logger.info("Image added successfully");
            } catch (SQLException e) {
                logger.error("Error executing the SQL query" + e.getMessage());
                throw new SQLException("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Error connecting to the database" + e.getMessage());
        }
    }

    @Override
    public String getEmergencyContactNumber(String name) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT emergency_contact_number FROM staff WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("emergency_contact_number");
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

    private Staff mapToStaff(ResultSet resultSet) throws SQLException {
        int staffId = resultSet.getInt("staff_id");
        String name = resultSet.getString("name");
        String personalPhone = resultSet.getString("personal_phone");
        String emergencyContactNumber = resultSet.getString("emergency_contact_number");
        String position = resultSet.getString("position");
        String citizenshipPhoto = resultSet.getString("citizenship_photo");
        String contactDocPdf = resultSet.getString("contact_doc_pdf");
        String joinDate = resultSet.getString("join_date");
        String contactRenewDate = resultSet.getString("contact_renew_date");
        double salary = resultSet.getDouble("salary");
        return new Staff(staffId, name, personalPhone, emergencyContactNumber, position, citizenshipPhoto, contactDocPdf, joinDate, contactRenewDate, salary);
    }
}
