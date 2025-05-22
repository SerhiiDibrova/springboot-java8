package hello.service;

import hello.model.IAnimal;
import hello.service.Logger;

public class AnimalService {
    private IAnimal _animal;

    public AnimalService(IAnimal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal instance is required");
        }
        this._animal = animal;
    }

    public String makeSound() {
        try {
            Logger.log("Making sound for the animal.");
            return _animal.Speak();
        } catch (Exception e) {
            Logger.log("Error while making sound: " + e.getMessage());
            throw e;
        }
    }
}