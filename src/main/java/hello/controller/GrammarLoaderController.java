package hello.controller;

import hello.service.GrammarLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrammarLoaderController {

    private final GrammarLoaderService grammarLoaderService;

    @Autowired
    public GrammarLoaderController(GrammarLoaderService grammarLoaderService) {
        this.grammarLoaderService = grammarLoaderService;
    }

    @GetMapping("/load-grammar")
    public ResponseEntity<String> loadGrammar() {
        try {
            grammarLoaderService.loadGrammar();
            return new ResponseEntity<>("Grammar loaded successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to load grammar: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}