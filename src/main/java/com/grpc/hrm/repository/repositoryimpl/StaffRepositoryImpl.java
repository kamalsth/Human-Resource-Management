package com.grpc.hrm.repository.repositoryimpl;

import com.grpc.hrm.entity.Staff;
import com.grpc.hrm.repository.StaffRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StaffRepositoryImpl implements StaffRepository {

    private final DataSource dataSource;

    public StaffRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Staff saveStaff(Staff staff) {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "INSERT INTO staff (name, personal_phone, emergency_contact_number, position,citizenship_photo,contact_doc_pdf,join_date,contact_renew_date) VALUES ('" + staff.getName() + "', '" + staff.getPersonalPhone() + "', '" + staff.getEmergencyContactNumber() + "', '" + staff.getPosition() + "', '" + staff.getCitizenshipPhoto() + "', '" + staff.getContactDocPdf() + "', '" + staff.getJoinDate() + "', '" + staff.getContactRenewDate() + "')";
                statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                System.out.println("Staff saved successfully");
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        staff.setStaffId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating staff failed, no ID obtained.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database" + e.getMessage());
        }
        return staff;
    }

    @Override
    public Staff getStaffById(int staffId) {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM staff WHERE staff_id = " + staffId;
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    return mapToStaff(resultSet);
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
    public List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM staff";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    staffList.add(mapToStaff(resultSet));
                }
            } catch (SQLException e) {
                System.out.println("Error executing the SQL query" + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to the database" + e.getMessage());
        }
        return staffList;
    }

    @Override
    public void updateStaff(int staffId, Staff staff) {
        try(Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "UPDATE staff SET name = '" + staff.getName() + "', personal_phone = '" + staff.getPersonalPhone() + "', emergency_contact_number = '" + staff.getEmergencyContactNumber() + "', position = '" + staff.getPosition() + "', citizenship_photo = '" + staff.getCitizenshipPhoto() + "', contact_doc_pdf = '" + staff.getContactDocPdf() + "', join_date = '" + staff.getJoinDate() + "', contact_renew_date = '" + staff.getContactRenewDate() + "' WHERE staff_id = " + staffId;
                statement.executeUpdate(sql);
                System.out.println("Staff updated successfully");
            } catch (SQLException e) {
                System.out.println("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database" + e.getMessage());
        }

    }

    @Override
    public void deleteStaff(int staffId) {
        try(Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database");
            try (Statement statement = connection.createStatement()) {
                String sql = "DELETE FROM staff WHERE staff_id = " + staffId;
                statement.executeUpdate(sql);
                System.out.println("Staff deleted successfully");
            } catch (SQLException e) {
                System.out.println("Error executing the SQL query" + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database" + e.getMessage());
        }
    }

    private Staff mapToStaff(ResultSet resultSet) throws SQLException {
        int staffId = resultSet.getInt("staff_id");
        String name = resultSet.getString("name");
        String personalPhone = resultSet.getString("personal_phone");
        String emergencyContactNumber = resultSet.getString("emergency_contact_number");
        String position = resultSet.getString("position");
        String citizenshipPhoto = resultSet.getString("citizenship_photo");
        String contactDocPdf = resultSet.getString("contact_doc_pdf");
        long joinDate = resultSet.getLong("join_date");
        long contactRenewDate = resultSet.getLong("contact_renew_date");
        return new Staff(staffId, name, personalPhone, emergencyContactNumber, position, citizenshipPhoto, contactDocPdf, joinDate, contactRenewDate);
    }
}