package hello.controller;

import hello.entity.TAjustMTSEntity;
import hello.repository.TAjustMTSRepository;
import hello.service.TAjustMTSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TAjustMTSController {

    @Autowired
    private TAjustMTSService tAjustMTSService;

    @Autowired
    private TAjustMTSRepository tAjustMTSRepository;

    @PostMapping("/handleTransaction")
    public ResponseEntity<TAjustMTSEntity> handleTransaction(@RequestBody TAjustMTSEntity tAjustMTSEntity) {
        if (tAjustMTSEntity == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        try {
            tAjustMTSService.validateUserInput(tAjustMTSEntity);
            tAjustMTSService.executeTransaction(tAjustMTSEntity);
            return new ResponseEntity<>(tAjustMTSEntity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getTransactionDetails")
    public ResponseEntity<TAjustMTSEntity> getTransactionDetails() {
        try {
            TAjustMTSEntity tAjustMTSEntity = tAjustMTSRepository.findTopByOrderByIdDesc();
            if (tAjustMTSEntity == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(tAjustMTSEntity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void FormShow() {
        // Initialize form components
        // Queries
        // Data sources
        // Radio groups
        System.out.println("Form components initialized");
    }

    public void ExecuteQueries() {
        // Drop query
        System.out.println("Drop query executed");
        // Sortie query
        System.out.println("Sortie query executed");
    }
}