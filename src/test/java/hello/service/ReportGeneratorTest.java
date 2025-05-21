package hello.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportGeneratorTest {
    private AnimalService animalService;
    private DatabaseService databaseService;
    private ReportGenerator reportGenerator;

    @BeforeEach
    void setUp() {
        animalService = mock(AnimalService.class);
        databaseService = mock(DatabaseService.class);
        reportGenerator = new ReportGenerator(animalService, databaseService);
    }

    @Test
    void testGenerate() {
        when(animalService.MakeSound()).thenReturn("meow");
        
        reportGenerator.Generate();
        
        verify(databaseService).Save("meow");
    }

    @Test
    void testGenerateHandlesError() {
        when(animalService.MakeSound()).thenThrow(new RuntimeException("Error generating sound"));
        
        assertThrows(RuntimeException.class, () -> reportGenerator.Generate());
    }
}