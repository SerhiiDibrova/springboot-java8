package hello.service;

import hello.model.IAnimal;

public class AnimalService {
    private IAnimal _animal;

    public AnimalService(IAnimal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal cannot be null");
        }
        this._animal = animal;
    }

    public String makeSound() {
        return _animal.Speak();
    }
}