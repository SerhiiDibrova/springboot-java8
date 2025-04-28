package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesDataController {

    @Autowired
    private SalesDataService salesDataService;

    @GetMapping("/sales-data")
    public ResponseEntity<List<SalesData>> getSalesData(@RequestParam Integer orderId, @RequestBody List<TempItemDTO> tempItems) {
        if (orderId == null || tempItems == null || tempItems.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        List<SalesData> salesData = salesDataService.getSalesData(orderId, tempItems);
        return ResponseEntity.ok(salesData);
    }
}