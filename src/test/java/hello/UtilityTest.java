package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilityTest {

    @Test
    public void testPrepare() {
        assertEquals("HELLO", Utility.Prepare("hello"));
        assertEquals("WORLD", Utility.Prepare("WoRlD"));
        assertEquals("", Utility.Prepare(""));
        assertEquals(null, Utility.Prepare(null));
        assertEquals("A", Utility.Prepare("a"));
        assertEquals("LONGSTRING", Utility.Prepare("longstring"));
        assertEquals("123", Utility.Prepare("123"));
        assertEquals("SPECIALCHARACTERS!@#", Utility.Prepare("specialcharacters!@#"));
    }
}