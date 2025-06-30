package hello.controller;

import hello.model.AjustMTSModel;
import hello.service.AjustMTSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class AjustMTSController {

    private final AjustMTSService ajustMTSService;
    private static final Logger logger = LoggerFactory.getLogger(AjustMTSController.class);

    @Autowired
    public AjustMTSController(AjustMTSService ajustMTSService) {
        this.ajustMTSService = ajustMTSService;
    }

    @PostMapping("/handle-transaction")
    public ResponseEntity<String> handleTransaction(@RequestBody AjustMTSModel ajustMTSModel) {
        try {
            if (ajustMTSService.valuesAreValid(ajustMTSModel)) {
                ajustMTSService.handleTransaction(ajustMTSModel);
                return new ResponseEntity<>("Transaction handled successfully", HttpStatus.OK);
            } else {
                logger.error("Invalid input");
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            logger.error("Error handling transaction", e);
            return new ResponseEntity<>("Error handling transaction", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cash-desks")
    public ResponseEntity<List<String>> getCashDesks() {
        try {
            List<String> cashDesks = ajustMTSService.getCashDesks();
            if (cashDesks == null || cashDesks.isEmpty()) {
                logger.error("No cash desks found");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cashDesks, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error getting cash desks", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/slot-machines")
    public ResponseEntity<List<String>> getSlotMachines() {
        try {
            List<String> slotMachines = ajustMTSService.getSlotMachines();
            if (slotMachines == null || slotMachines.isEmpty()) {
                logger.error("No slot machines found");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(slotMachines, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error getting slot machines", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}