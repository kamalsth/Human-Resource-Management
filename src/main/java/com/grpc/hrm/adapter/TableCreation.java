package com.grpc.hrm.adapter;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class TableCreation {

    private final DataSource dataSource;

    public TableCreation(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createTableIfNotExist(){
        String createStaffTableQuery="CREATE TABLE IF NOT EXISTS staff ("
                + "staff_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "personal_phone VARCHAR(15) NOT NULL,"
                + "emergency_contact_number VARCHAR(15) NOT NULL,"
                + "position VARCHAR(255) NOT NULL,"
                + "citizenship_photo VARCHAR(255) NOT NULL,"
                + "contact_doc_pdf VARCHAR(255) NOT NULL,"
                + "join_date BIGINT NOT NULL,"
                + "contact_renew_date BIGINT NOT NULL"
                + ")";
        createTableIfNotExists("staff",createStaffTableQuery);
    }
    private void createTableIfNotExists(String tableName, String createTableQuery) {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            if (!tableExists(connection, tableName)) {
                statement.execute(createTableQuery);
                System.out.println("Table " + tableName + " created successfully.");
            } else {
                System.out.println("Table " + tableName + " already exists.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean tableExists(Connection connection, String tableName) throws SQLException {
        String checkTableQuery = "SHOW TABLES LIKE '" + tableName + "'";
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(checkTableQuery).next();
        }
    }
}
