package hello.service;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class GrammarLoaderTest {

    @Test
    public void testCanLoadGrammar() {
        GrammarLoader grammarLoader = new GrammarLoader();
        boolean isLoaded = grammarLoader.loadGrammar();
        assertTrue(isLoaded);
    }
}