package com.grpc.hrm.repository.repositoryimpl;

import com.grpc.hrm.model.MaritalStatus;
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
            String sql = "INSERT INTO staff (staff_id,name, personal_phone, emergency_contact_number, " +
                    "position,citizenship_photo,contact_doc_pdf,join_date," +
                    "contact_renew_date,salary,marital_status,email," +
                    "social_security_fund,employees_provident_fund,citizen_investment_trust,insurance) " +
                    "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, staff.getStaffId());
                preparedStatement.setString(2, staff.getName());
                preparedStatement.setString(3, staff.getPersonalPhone());
                preparedStatement.setString(4, staff.getEmergencyContactNumber());
                preparedStatement.setString(5, staff.getPosition());
                preparedStatement.setString(6, staff.getCitizenshipPhoto());
                preparedStatement.setString(7, staff.getContactDocPdf());
                preparedStatement.setLong(8, staff.getJoinDate());
                preparedStatement.setLong(9, staff.getContactRenewDate());
                preparedStatement.setDouble(10, staff.getSalary());
                preparedStatement.setString(11, staff.getMaritalStatus().name());
                preparedStatement.setString(12, staff.getEmail());
                preparedStatement.setDouble(13, staff.getSocialSecurityFund());
                preparedStatement.setDouble(14, staff.getEmployeesProvidentFund());
                preparedStatement.setDouble(15, staff.getCitizenInvestmentTrust());
                preparedStatement.setDouble(16, staff.getInsurance());

                preparedStatement.executeUpdate();

                logger.info("Staff saved successfully");

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        staff.setStaffId(generatedKeys.getString(1));
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
    public Staff getStaffById(String staffId) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM staff WHERE staff_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, staffId);

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
    public List<Staff> getAllStaff(int pageNumber, int pageSize) {
        List<Staff> staffList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM staff LIMIT ?, ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, pageNumber * pageSize);
                preparedStatement.setInt(2, pageSize);
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
    public Staff updateStaff(String staffId, Staff staff) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "UPDATE staff SET name = ?, personal_phone = ?, " +
                    "emergency_contact_number = ?, position = ?, " +
                    "citizenship_photo = ?, contact_doc_pdf = ?, join_date = ?," +
                    " contact_renew_date = ?, salary = ? , " +
                    "marital_status=? ,email=? ," +
                    "social_security_fund=?, " +
                    "employees_provident_fund=? ," +
                    "citizen_investment_trust=?, " +
                    "insurance=?" +
                    "WHERE staff_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, staff.getName());
                preparedStatement.setString(2, staff.getPersonalPhone());
                preparedStatement.setString(3, staff.getEmergencyContactNumber());
                preparedStatement.setString(4, staff.getPosition());
                preparedStatement.setString(5, staff.getCitizenshipPhoto());
                preparedStatement.setString(6, staff.getContactDocPdf());
                preparedStatement.setLong(7, staff.getJoinDate());
                preparedStatement.setLong(8, staff.getContactRenewDate());
                preparedStatement.setDouble(9, staff.getSalary());
                preparedStatement.setString(10, staff.getMaritalStatus().name());
                preparedStatement.setString(11, staff.getEmail());
                preparedStatement.setDouble(12, staff.getSocialSecurityFund());
                preparedStatement.setDouble(13, staff.getEmployeesProvidentFund());
                preparedStatement.setDouble(14, staff.getCitizenInvestmentTrust());
                preparedStatement.setDouble(15, staff.getInsurance());
                preparedStatement.setString(16, staffId);


                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    logger.info("Staff updated successfully");

                    // Fetch the updated staff details
                    return getStaffById(staffId);
                } else {
                    throw new SQLException("Failed to update staff. No rows were affected.");
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
    public void deleteStaff(String staffId) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "DELETE FROM staff WHERE staff_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, staffId);

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
    public void addFileByStaffId(String staffId, String filePath) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "UPDATE staff SET contact_doc_pdf = ? WHERE staff_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, filePath);
                preparedStatement.setString(2, staffId);

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
    public void addImageByStaffId(String staffId, String filePath) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "UPDATE staff SET citizenship_photo = ? WHERE staff_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, filePath);
                preparedStatement.setString(2, staffId);

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
    public Staff getStaffByEmail(String email) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM staff WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);

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
    public Staff getStaffByEmergencyContactNumber(String emergencyContactNumber) {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Connected to the database");
            String sql = "SELECT * FROM staff WHERE emergency_contact_number = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, emergencyContactNumber);

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


    private Staff mapToStaff(ResultSet resultSet) throws SQLException {
        String staffId = resultSet.getString("staff_id");
        String name = resultSet.getString("name");
        String personalPhone = resultSet.getString("personal_phone");
        String emergencyContactNumber = resultSet.getString("emergency_contact_number");
        String position = resultSet.getString("position");
        String citizenshipPhoto = resultSet.getString("citizenship_photo");
        String contactDocPdf = resultSet.getString("contact_doc_pdf");
        long joinDate = resultSet.getLong("join_date");
        long contactRenewDate = resultSet.getLong("contact_renew_date");
        double salary = resultSet.getDouble("salary");
        MaritalStatus maritalStatus = MaritalStatus.valueOf(resultSet.getString("marital_status"));
        String email = resultSet.getString("email");
        double socialSecurityFund = resultSet.getDouble("social_security_fund");
        double employeesProvidentFund = resultSet.getDouble("employees_provident_fund");
        double citizenInvestmentTrust = resultSet.getDouble("citizen_investment_trust");
        double insurance = resultSet.getDouble("insurance");
        return new Staff(staffId, name, personalPhone, emergencyContactNumber, position, citizenshipPhoto, contactDocPdf, joinDate, contactRenewDate, salary, maritalStatus, email, socialSecurityFund, employeesProvidentFund, citizenInvestmentTrust, insurance);
    }
}
