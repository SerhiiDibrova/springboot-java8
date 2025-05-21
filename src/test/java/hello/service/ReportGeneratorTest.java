package hello.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ReportGeneratorTest {

    @Mock
    private AnimalService animalService;

    @Mock
    private DatabaseService databaseService;

    @InjectMocks
    private ReportGenerator reportGenerator;

    @Test
    public void testGenerate() {
        when(animalService.MakeSound()).thenReturn("Meow");
        reportGenerator.Generate();
        verify(databaseService).save("MEOW");
    }
}