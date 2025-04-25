package hello.repository;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.ServletRequest;
import hello.repository.DatabaseConnection;

public class DatabaseConnectionUtils {

    public static DatabaseConnection getDbConnection(ServletRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("ServletRequest object is null");
        }
        
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            throw new IllegalStateException("ServletRequestAttributes object is null");
        }
        
        ServletRequest servletRequest = servletRequestAttributes.getRequest();
        if (servletRequest == null) {
            throw new IllegalStateException("ServletRequest object is null");
        }
        
        DatabaseConnection databaseConnection = (DatabaseConnection) servletRequest.getAttribute("DatabaseConnection");
        if (databaseConnection == null) {
            throw new IllegalStateException("DatabaseConnection object is null");
        }
        
        return databaseConnection;
    }
}