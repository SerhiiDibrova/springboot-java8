package hello.service;

import hello.Utility;
import hello.service.AnimalService;
import hello.repository.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ReportGenerator {
    private final AnimalService _animalService;
    private final Database _database;
    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);

    @Autowired
    public ReportGenerator(AnimalService animalService, Database database) {
        this._animalService = animalService;
        this._database = database;
    }

    public void Generate() {
        try {
            String sound = _animalService.MakeSound();
            if (sound == null || sound.isEmpty()) {
                logger.error("Animal sound is null or empty");
                return;
            }
            String preparedData = Utility.Prepare(sound);
            _database.Save(preparedData);
        } catch (NullPointerException e) {
            logger.error("Null pointer exception occurred", e);
        } catch (IllegalArgumentException e) {
            logger.error("Illegal argument exception occurred", e);
        } catch (Exception e) {
            logger.error("Error generating report", e);
        }
    }
} 

package hello.service;

import hello.Utility;
import hello.service.AnimalService;
import hello.repository.Database;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ReportGeneratorTest {
    @Mock
    private AnimalService animalService;

    @Mock
    private Database database;

    @InjectMocks
    private ReportGenerator reportGenerator;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateWithValidSound() {
        when(animalService.MakeSound()).thenReturn("Roar");
        reportGenerator.Generate();
        verify(database).Save("Prepared: Roar");
    }

    @Test
    void testGenerateWithNullSound() {
        when(animalService.MakeSound()).thenReturn(null);
        reportGenerator.Generate();
        verify(database, never()).Save(anyString());
    }

    @Test
    void testGenerateWithEmptySound() {
        when(animalService.MakeSound()).thenReturn("");
        reportGenerator.Generate();
        verify(database, never()).Save(anyString());
    }
}