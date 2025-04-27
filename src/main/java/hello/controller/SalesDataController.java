package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SalesDataController {

    @Autowired
    private SalesDataService salesDataService;

    @PostMapping("/sales-data")
    public ResponseEntity<List<SalesData>> getSalesData(@RequestParam(required = false) Integer orderId, @RequestBody(required = false) List<Item> tempItems) {
        if (orderId == null || tempItems == null || tempItems.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            List<SalesData> salesData = salesDataService.getSalesData(orderId, tempItems);
            return ResponseEntity.ok(salesData);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}