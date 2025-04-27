package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import hello.service.TempItemsService;
import hello.dto.TempItemsDTO;

@RestController
public class TempItemsController {

    @Autowired
    private TempItemsService tempItemsService;

    @PostMapping(value = "/temp-items", consumes = "application/json")
    public ResponseEntity<String> insertTempItems(@RequestBody TempItemsDTO tempItemsDTO) {
        if (tempItemsDTO == null || tempItemsDTO.getOrderId() == null || tempItemsDTO.getOrderId().isEmpty() || 
            tempItemsDTO.getItemName() == null || tempItemsDTO.getItemName().isEmpty() || 
            tempItemsDTO.getQuantity() <= 0) {
            return ResponseEntity.badRequest().body("Invalid input: Order ID, Item Name, and Quantity must be valid");
        }
        try {
            tempItemsService.insertTempItems(tempItemsDTO);
            return ResponseEntity.ok("Insertion successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Insertion failed: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Insertion failed: " + e.getMessage());
        }
    }
}