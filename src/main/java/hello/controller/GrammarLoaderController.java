package hello.controller;

import hello.service.GrammarLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class GrammarLoaderController {

    private final GrammarLoaderService grammarLoaderService;
    private static final Logger logger = LoggerFactory.getLogger(GrammarLoaderController.class);

    @Autowired
    public GrammarLoaderController(GrammarLoaderService grammarLoaderService) {
        this.grammarLoaderService = grammarLoaderService;
    }

    @GetMapping("/test-can-load-grammar")
    public ResponseEntity<String> testCanLoadGrammar() {
        try {
            grammarLoaderService.loadGrammar();
            logger.info("Grammar loading was successful");
            return new ResponseEntity<>("Grammar loading was successful", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Grammar loading failed: " + e.getMessage(), e);
            return new ResponseEntity<>("Grammar loading failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}