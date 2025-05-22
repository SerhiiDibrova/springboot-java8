package hello.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {

    @Test
    public void testSpeak() {
        Cat cat = new Cat();
        String sound = cat.Speak();
        assertEquals("Meow", sound);
    }
}