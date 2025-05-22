package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IAnimal {
    String Speak();
}

public class Cat implements IAnimal {
    private static final Logger logger = LoggerFactory.getLogger(Cat.class);

    @Override
    public String Speak() {
        String sound = "Meow";
        logger.info("Cat speaks: {}", sound);
        return sound;
    }
}

package hello.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {

    @Test
    public void testSpeak() {
        Cat cat = new Cat();
        String sound = cat.Speak();
        assertEquals("Meow", sound, "The cat should say 'Meow'");
    }
}