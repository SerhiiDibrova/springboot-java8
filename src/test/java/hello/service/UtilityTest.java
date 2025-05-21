package hello.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilityTest {

    @Test
    public void testPrepare() {
        assertEquals("HELLO", Utility.Prepare("hello"));
        assertEquals("WORLD", Utility.Prepare("WoRlD"));
        assertEquals("", Utility.Prepare(""));
        assertEquals(null, Utility.Prepare(null));
    }

    @Test
    public void testPrepareWithLargeInput() {
        StringBuilder largeInput = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            largeInput.append("a");
        }
        assertEquals(largeInput.toString().toUpperCase(), Utility.Prepare(largeInput.toString()));
    }

    @Test
    public void testPrepareWithMixedInputSizes() {
        assertEquals("A", Utility.Prepare("a"));
        assertEquals("AB", Utility.Prepare("ab"));
        assertEquals("ABC", Utility.Prepare("abc"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Utility.Prepare("abcdefghijklmnopqrstuvwxyz"));
    }
}