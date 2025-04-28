package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import hello.exception.DatabaseConnectionException;
import hello.model.DatabaseConnection;
import javax.servlet.http.HttpServletRequest;

@Service
public class DatabaseConnectionService {

    public DatabaseConnection getDbConnection(HttpServletRequest request) throws DatabaseConnectionException {
        DatabaseConnection connection = null;
        try {
            connection = (DatabaseConnection) request.getAttribute("dbConnection");
            if (connection == null) {
                throw new DatabaseConnectionException("Database connection is null");
            }
            return connection;
        } catch (Exception e) {
            throw new DatabaseConnectionException("Failed to retrieve database connection: " + e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    // Log the exception or handle it as needed
                }
            }
        }
    }
}