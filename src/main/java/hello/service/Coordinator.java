package hello.service;

import hello.service.LoggerService;
import hello.service.AnimalService;
import hello.model.Dog;

public class Coordinator {
    private final LoggerService loggerService;
    private final AnimalService animalService;

    public Coordinator(LoggerService loggerService) {
        this.loggerService = loggerService;
        this.animalService = new AnimalService(new Dog());
    }

    public void run() {
        String sound = animalService.makeSound();
        loggerService.log("Dog sound: " + sound);
    }
}