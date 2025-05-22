package hello.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DogTest {

    @Test
    public void testSpeak() {
        Dog dog = new Dog();
        Assertions.assertEquals("Woof", dog.Speak());
    }
}