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

    @GetMapping("/test-can-load-grammar")
    public ResponseEntity<GrammarLoadResponse> testCanLoadGrammar() {
        try {
            boolean result = grammarLoaderService.loadGrammar();
            GrammarLoadResponse response = new GrammarLoadResponse(result, "Grammar loading was successful");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (NullPointerException e) {
            GrammarLoadResponse response = new GrammarLoadResponse(false, "Null pointer exception occurred");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            GrammarLoadResponse response = new GrammarLoadResponse(false, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

class GrammarLoadResponse {
    private boolean success;
    private String message;

    public GrammarLoadResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}