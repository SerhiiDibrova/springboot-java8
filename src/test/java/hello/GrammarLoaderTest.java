package hello;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class GrammarLoaderTest {

    @Test
    public void testLoadGrammar() {
        GrammarLoaderService grammarLoaderService = new GrammarLoaderService();
        boolean result = grammarLoaderService.loadGrammar();
        assertTrue(result);
    }
}