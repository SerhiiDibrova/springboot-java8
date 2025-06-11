package hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.GrammarLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class GrammarLoaderController {

    private static final Logger logger = LoggerFactory.getLogger(GrammarLoaderController.class);

    @GetMapping("/testCanLoadGrammar")
    public boolean testCanLoadGrammar() {
        try {
            GrammarLoader grammarLoader = new GrammarLoader();
            return grammarLoader.loadGrammar();
        } catch (Exception e) {
            logger.error("Error loading grammar", e);
            return false;
        }
    }
}