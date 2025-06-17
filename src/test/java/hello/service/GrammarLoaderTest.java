package hello.service;

import hello.repository.GrammarLoaderRepository;
import hello.service.GrammarLoaderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.NotNull;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@EnableJpaRepositories
@ComponentScan("hello")
@SpringBootTest
@RunWith(SpringRunner.class)
public class GrammarLoaderTest {

    @Mock
    private GrammarLoaderRepository grammarLoaderRepository;

    @InjectMocks
    private GrammarLoaderService grammarLoaderService;

    @Test
    public void testLoadGrammar() {
        when(grammarLoaderRepository.loadGrammar(anyString())).thenReturn("expected result");
        String result = grammarLoaderService.loadGrammar("test grammar");
        assertEquals("expected result", result);
    }

    @Test
    public void testLoadGrammarNullInput() {
        assertThrows(NullPointerException.class, () -> grammarLoaderService.loadGrammar(null));
    }

    @Test
    public void testLoadGrammarEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> grammarLoaderService.loadGrammar(""));
    }
}