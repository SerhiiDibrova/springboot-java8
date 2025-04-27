package hello.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
public class SalesDataController {

    @Autowired
    private SalesDataService salesDataService;

    @PostMapping("/salesData")
    public ResponseEntity<List<SalesData>> getSalesData(@RequestParam Integer orderId, @RequestBody List<Item> tempItems) {
        if (orderId == null || tempItems == null || tempItems.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            List<SalesData> salesData = salesDataService.retrieveSalesData(orderId, tempItems);
            return ResponseEntity.ok(salesData);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}