package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Utility {
    public static String prepare(String input) {
        return input == null ? null : input.toUpperCase();
    }
}

class UtilityTest {
    @Test
    void testPrepareWithNullInput() {
        assertNull(Utility.prepare(null));
    }

    @Test
    void testPrepareWithEmptyString() {
        assertEquals("", Utility.prepare(""));
    }

    @Test
    void testPrepareWithLowercaseInput() {
        assertEquals("HELLO", Utility.prepare("hello"));
    }

    @Test
    void testPrepareWithMixedCaseInput() {
        assertEquals("HELLO WORLD", Utility.prepare("Hello World"));
    }

    @Test
    void testPrepareWithAlreadyUppercaseInput() {
        assertEquals("HELLO", Utility.prepare("HELLO"));
    }
}