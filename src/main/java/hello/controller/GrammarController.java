package hello.controller;

import hello.service.GrammarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrammarController {

    private final GrammarService grammarService;

    @Autowired
    public GrammarController(GrammarService grammarService) {
        this.grammarService = grammarService;
    }

    @GetMapping("/testCanLoadGrammar")
    public String testCanLoadGrammar() {
        return grammarService.loadGrammarData();
    }
}