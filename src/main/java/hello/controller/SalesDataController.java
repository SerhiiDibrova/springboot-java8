package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SalesDataController {

    @Autowired
    private SalesDataService salesDataService;

    @GetMapping("/sales-data")
    public ResponseEntity<List<SalesData>> getSalesData(@RequestParam Integer orderId, @RequestBody List<ItemDTO> tempItems) {
        if (tempItems == null || tempItems.isEmpty()) {
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