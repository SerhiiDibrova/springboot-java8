package hello.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Cat {
    public String speak() {
        return "Meow";
    }
}

public class CatTest {

    @Test
    public void testSpeak() {
        Cat cat = new Cat();
        String result = cat.speak();
        assertEquals("Meow", result);
    }
}