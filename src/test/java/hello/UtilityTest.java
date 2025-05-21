package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilityTest {

    @Test
    public void testPrepare() {
        assertEquals("HELLO", Utility.Prepare("hello"));
        assertEquals("WORLD", Utility.Prepare("world"));
        assertEquals("JAVA", Utility.Prepare("Java"));
        assertEquals("", Utility.Prepare(""));
        assertEquals("123", Utility.Prepare("123"));
    }
}