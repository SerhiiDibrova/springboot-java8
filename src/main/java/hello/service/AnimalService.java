package hello.service;

import hello.declaration.IAnimal;

public class AnimalService {
    private IAnimal _animal;

    public AnimalService(IAnimal animal) {
        this._animal = animal;
    }

    public String MakeSound() {
        return _animal.Speak();
    }
}