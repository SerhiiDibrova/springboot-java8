package hello.controller;

import hello.model.Cat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

    @GetMapping("/cat/speak")
    public ResponseEntity<String> speak() {
        try {
            Cat cat = new Cat();
            String sound = cat.Speak();
            return ResponseEntity.ok(sound);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}