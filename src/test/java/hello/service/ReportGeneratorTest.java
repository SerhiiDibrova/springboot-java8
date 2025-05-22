package hello.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportGeneratorTest {

    private AnimalService animalService;
    private Database database;
    private ReportGenerator reportGenerator;

    @BeforeEach
    void setUp() {
        animalService = mock(AnimalService.class);
        database = mock(Database.class);
        reportGenerator = new ReportGenerator(animalService, database);
    }

    @Test
    void testGenerate() {
        when(animalService.MakeSound()).thenReturn("Woof!");
        when(Utility.Prepare("Woof!")).thenReturn("WOOF!");

        try {
            reportGenerator.Generate();
        } catch (Exception e) {
            fail("Generate() should not throw an exception");
        }

        verify(database).Save("WOOF!");
    }

    @Test
    void testGenerateHandlesException() {
        when(animalService.MakeSound()).thenThrow(new RuntimeException("Service error"));

        try {
            reportGenerator.Generate();
            fail("Generate() should throw an exception");
        } catch (Exception e) {
            assertEquals("Service error", e.getMessage());
        }
    }
}