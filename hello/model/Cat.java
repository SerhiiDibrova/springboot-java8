package hello.model;

public interface IAnimal {
    String Speak();
}

public class Cat implements IAnimal {
    @Override
    public String Speak() {
        return "Meow";
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {
    @Test
    public void testSpeak() {
        Cat cat = new Cat();
        assertEquals("Meow", cat.Speak());
    }
}