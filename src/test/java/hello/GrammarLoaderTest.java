package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GrammarLoaderTest {

    @Mock
    private GrammarLoaderRepository grammarLoaderRepository;

    @InjectMocks
    private GrammarLoaderService grammarLoaderService;

    @Test
    public void testLoadGrammar_HappyPath() {
        when(grammarLoaderRepository.loadGrammar(anyString())).thenReturn("Loaded Grammar");
        String result = grammarLoaderService.loadGrammar("test");
        assertEquals("Loaded Grammar", result);
    }

    @Test
    public void testLoadGrammar_ErrorPath() {
        when(grammarLoaderRepository.loadGrammar(anyString())).thenThrow(new RuntimeException("Error loading grammar"));
        assertThrows(RuntimeException.class, () -> grammarLoaderService.loadGrammar("test"));
    }
}