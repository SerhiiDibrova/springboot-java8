package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationShutdownListener implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private DatabaseConnection databaseConnection;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        if (databaseConnection != null) {
            try {
                databaseConnection.close();
            } catch (Exception e) {
                // Handle error during database connection close
            }
        }
    }
}