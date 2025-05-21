package hello.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ReportGeneratorTest {

    private AnimalService mockAnimalService;
    private DatabaseService mockDatabaseService;
    private ReportGenerator reportGenerator;
    private Logger logger;

    @BeforeEach
    void setUp() {
        mockAnimalService = mock(AnimalService.class);
        mockDatabaseService = mock(DatabaseService.class);
        logger = LoggerFactory.getLogger(ReportGeneratorTest.class);
        reportGenerator = new ReportGenerator(mockAnimalService, mockDatabaseService, logger);
    }

    @Test
    void testGenerate() {
        when(mockAnimalService.MakeSound()).thenReturn("Meow");

        reportGenerator.Generate();

        verify(mockDatabaseService).Save("MEOW");
    }

    @Test
    void testGenerateHandlesException() {
        when(mockAnimalService.MakeSound()).thenThrow(new RuntimeException("Service error"));

        reportGenerator.Generate();

        verify(logger).error(anyString(), any(RuntimeException.class));
    }
}