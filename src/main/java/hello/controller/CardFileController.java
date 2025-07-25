package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import hello.service.CardFileService;
import hello.exception.CardFileReadException;

@RestController
public class CardFileController {

    private final CardFileService cardFileService;

    public CardFileController(CardFileService cardFileService) {
        this.cardFileService = cardFileService;
    }

    @GetMapping("/readCardFile")
    public ResponseEntity<String> readCardFile() {
        try {
            cardFileService.readCardFile();
            return new ResponseEntity<>("Card file read successfully", HttpStatus.OK);
        } catch (CardFileReadException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while reading the card file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}