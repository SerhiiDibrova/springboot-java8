package hello.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class DatabaseServiceTest {

    @Test
    void testSave() {
        DatabaseService databaseService = new DatabaseService();
        String testData = "Test Data";
        String expectedOutput = "Saved: " + testData;

        Assertions.assertEquals(expectedOutput, databaseService.save(testData));
    }
}