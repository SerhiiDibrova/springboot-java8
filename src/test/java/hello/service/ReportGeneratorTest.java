package hello.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import hello.service.ReportGenerator;
import hello.service.AnimalService;
import hello.service.IDatabase;
import hello.service.LoggerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReportGeneratorTest {

    @Mock
    private AnimalService animalService;

    @Mock
    private IDatabase database;

    @Mock
    private LoggerService loggerService;

    @InjectMocks
    private ReportGenerator reportGenerator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerate() {
        String expectedSound = "Roar";
        when(animalService.MakeSound()).thenReturn(expectedSound);

        reportGenerator.Generate();

        verify(database).Save(contains(expectedSound));
        verify(loggerService).Log("Report generated successfully");
    }

    @Test
    public void testGenerate_logsErrorOnException() {
        when(animalService.MakeSound()).thenThrow(new RuntimeException("Error"));

        reportGenerator.Generate();

        verify(loggerService).Log("Error generating report: Error");
    }

    @Test
    public void testGenerate_withValidSound() {
        String expectedSound = "Bark";
        when(animalService.MakeSound()).thenReturn(expectedSound);

        reportGenerator.Generate();

        verify(database).Save(contains(expectedSound));
        verify(loggerService).Log("Report generated successfully");
    }
}