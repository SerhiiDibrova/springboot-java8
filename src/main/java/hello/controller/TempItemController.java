package hello.controller;

import hello.service.TempItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TempItemController {

    private final TempItemService tempItemService;

    @Autowired
    public TempItemController(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    @PostMapping("/tempitems")
    public ResponseEntity<Void> insertTempItems(@RequestParam String orderId, @RequestParam String xmlData) {
        if (orderId == null || orderId.isEmpty() || xmlData == null || xmlData.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input data");
        }
        try {
            tempItemService.insertTempItems(orderId, xmlData);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error processing request", e);
        }
    }
}