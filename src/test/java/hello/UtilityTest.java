package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilityTest {

    @Test
    public void testPrepare() {
        assertEquals("HELLO", Utility.Prepare("hello"));
        assertEquals("WORLD", Utility.Prepare("WoRlD"));
        assertEquals("", Utility.Prepare(""));
        assertEquals(null, Utility.Prepare(null));
    }

    @Test
    public void testPrepareWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            Utility.Prepare(null);
        });
    }
}