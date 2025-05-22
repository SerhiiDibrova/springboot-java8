package hello;

import org.junit.Test;
import org.junit.Assert;

public class UtilityTest {

    @Test
    public void testPrepareNormalString() {
        String result = Utility.Prepare("hello");
        Assert.assertEquals("HELLO", result);
    }

    @Test
    public void testPrepareEmptyString() {
        String result = Utility.Prepare("");
        Assert.assertEquals("", result);
    }

    @Test
    public void testPrepareUppercaseString() {
        String result = Utility.Prepare("WORLD");
        Assert.assertEquals("WORLD", result);
    }

    @Test
    public void testPrepareMixedCaseString() {
        String result = Utility.Prepare("HeLLo WoRLD");
        Assert.assertEquals("HELLO WORLD", result);
    }
}

package hello;

public class Utility {
    public static String Prepare(String input) {
        if (input == null) {
            return null;
        }
        return input.trim().toUpperCase().replaceAll("\\s+", " ");
    }
}