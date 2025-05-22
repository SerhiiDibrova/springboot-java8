package hello.service;

import hello.model.IAnimal;
import hello.service.LoggerService;

public class AnimalService {
    private IAnimal _animal;

    public AnimalService(IAnimal animal) {
        if (animal == null) {
            throw new NullPointerException("Animal instance is required");
        }
        this._animal = animal;
    }

    public String MakeSound() {
        LoggerService.log("MakeSound called");
        return _animal.Speak();
    }
}