package hello.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DatabaseServiceTest {

    @Test
    public void testSave() {
        DatabaseService databaseService = new DatabaseService();
        String testData = "Test Data";
        try {
            databaseService.save(testData);
            Assertions.assertEquals("Saved: Test Data", databaseService.getLastLog());
        } catch (Exception e) {
            Assertions.fail("Exception thrown during save: " + e.getMessage());
        }
    }
}