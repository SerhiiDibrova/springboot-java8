package hello.service;

import hello.model.Dog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalServiceTest {

    @Test
    public void testDogSpeak() {
        Dog dog = new Dog();
        assertEquals("Woof", dog.Speak());
    }
}