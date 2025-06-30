package hello.controller;

import hello.service.AjustMotifDlgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjustMotifDlgController {

    private final AjustMotifDlgService ajustMotifDlgService;

    @Autowired
    public AjustMotifDlgController(AjustMotifDlgService ajustMotifDlgService) {
        this.ajustMotifDlgService = ajustMotifDlgService;
    }

    @PostMapping("/ajustMotifDlg")
    public ResponseEntity<String> createTransaction(@RequestBody String request) {
        try {
            ajustMotifDlgService.createTransaction(request);
            return new ResponseEntity<>("Transaction created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating transaction: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ajustMotifDlg")
    public ResponseEntity<String> getTransactionInfo() {
        try {
            String transactionInfo = ajustMotifDlgService.getTransactionInfo();
            return new ResponseEntity<>(transactionInfo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving transaction info: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}