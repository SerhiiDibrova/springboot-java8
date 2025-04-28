package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class ShutdownEventService {

    private static final Logger logger = LoggerFactory.getLogger(ShutdownEventService.class);

    @Autowired
    private DataSource dataSource;

    @EventListener
    public void shutdownEvent(ContextClosedEvent event) {
        if (dataSource == null) {
            logger.error("DataSource is null, cannot close connection.");
            return;
        }
        
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                logger.info("Database connection closed successfully.");
            } else {
                logger.warn("Connection was already closed or null.");
            }
        } catch (SQLException e) {
            logger.error("Error closing database connection: ", e);
        }
    }
}