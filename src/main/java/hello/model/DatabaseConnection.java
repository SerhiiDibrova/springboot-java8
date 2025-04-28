package hello.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private String url;
    private String user;
    private String password;
    private int connectionTimeout;
    private String databaseType;
    private Connection connection;

    public DatabaseConnection(String url, String user, String password, int connectionTimeout, String databaseType) {
        if (url == null || user == null || password == null || connectionTimeout <= 0 || databaseType == null) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionTimeout = connectionTimeout;
        this.databaseType = databaseType;
    }

    public void openConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                DriverManager.setLoginTimeout(connectionTimeout);
                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error opening database connection", e);
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error closing database connection", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public String getDatabaseType() {
        return databaseType;
    }
}