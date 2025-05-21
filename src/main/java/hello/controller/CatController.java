package hello.controller;

import hello.model.Cat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class CatController {
    private static final Logger logger = Logger.getLogger(CatController.class.getName());

    @GetMapping("/cat/speak")
    public ResponseEntity<String> testSpeak() {
        try {
            Cat cat = new Cat();
            String sound = cat.Speak();
            logger.info(sound);
            if (!"Meow".equals(sound)) {
                throw new RuntimeException("Unexpected sound from Cat: " + sound);
            }
            return ResponseEntity.ok(sound);
        } catch (Exception e) {
            logger.severe("Error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}