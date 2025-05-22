package hello.controller;

import hello.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AnimalController {

    private final AnimalService animalService;
    private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/dog/speak")
    public ResponseEntity<String> speak() {
        try {
            String sound = animalService.makeSound();
            if (sound == null || sound.isEmpty()) {
                logger.error("Service returned an empty sound");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
            }
            return ResponseEntity.ok(sound);
        } catch (Exception e) {
            logger.error("Error occurred while getting dog sound", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}