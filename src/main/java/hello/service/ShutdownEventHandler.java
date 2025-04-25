package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;

@Component
public class ShutdownEventHandler {

    @Autowired
    private DatabaseConnectionUtils databaseConnectionUtils;

    @Async
    @PreDestroy
    public void shutdown_event() {
        try {
            databaseConnectionUtils.getConnection().close();
        } catch (java.sql.SQLException e) {
            // Handle SQL exception
        } catch (Exception e) {
            // Handle general exception
        }
    }
}