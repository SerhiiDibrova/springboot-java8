package hello.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseServiceTest {
    private final Logger logger = LoggerFactory.getLogger(DatabaseServiceTest.class);
    private final DatabaseService databaseService = new DatabaseService();

    @Test
    public void testSaveLogsCorrectMessage() {
        String testData = "Test Data";
        String expectedLogMessage = "Saved: " + testData;

        try {
            databaseService.Save(testData);
            String actualLogMessage = captureLogOutput();
            assertEquals(expectedLogMessage, actualLogMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String captureLogOutput() {
        // Implement log capturing logic here
        // This is a placeholder for actual log capturing implementation
        return ""; 
    }
}