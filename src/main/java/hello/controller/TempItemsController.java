package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.service.TempItemsService;

@RestController
public class TempItemsController {

    @Autowired
    private TempItemsService tempItemsService;

    @PostMapping("/temp-items")
    public ResponseEntity<String> insertTempItems(@RequestParam("orderId") String orderId, @RequestParam("xmlData") String xmlData) {
        if (orderId == null || orderId.isEmpty() || xmlData == null || xmlData.isEmpty()) {
            return ResponseEntity.badRequest().body("Order ID and XML data must not be empty");
        }
        try {
            tempItemsService.insertTempItems(orderId, xmlData);
            return ResponseEntity.ok("Insertion successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Insertion failed: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Insertion failed: " + e.getMessage());
        }
    }
}