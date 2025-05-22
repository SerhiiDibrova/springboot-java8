package hello.model;

public interface Animal {
    String speak();
}

package hello.model;

public class Dog implements Animal {
    @Override
    public String speak() {
        return "Bark";
    }
}

package hello.model;

public class Cat implements Animal {
    @Override
    public String speak() {
        return "Meow";
    }
}

package hello.service;

import hello.model.Animal;

public class AnimalService {
    public String makeAnimalSpeak(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal cannot be null");
        }
        return animal.speak();
    }
}