package hello.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class Dog {
    public String speak() {
        return "Woof";
    }
}

public class DogTest {

    @Test
    public void testSpeak() {
        Dog dog = new Dog();
        String result = dog.speak();
        Assertions.assertEquals("Woof", result);
    }
}