package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalService {
    private Animal _animal;
    private static final Logger logger = LoggerFactory.getLogger(AnimalService.class);

    public AnimalService(Animal animal) {
        this._animal = animal;
    }

    public String makeSound() {
        if (_animal == null) {
            logger.error("Animal reference is null");
            return "No sound";
        }
        logger.info("MakeSound method called.");
        return _animal.Speak();
    }
}