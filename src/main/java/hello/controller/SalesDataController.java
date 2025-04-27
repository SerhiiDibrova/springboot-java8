package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesDataController {

    @Autowired
    private GetSalesDataService getSalesDataService;

    @GetMapping("/salesdata")
    public ResponseEntity<List<SalesData>> getSalesData(@RequestParam(required = false) String orderId, 
                                                         @RequestParam(required = false) List<String> tempItems) {
        if (orderId == null && (tempItems == null || tempItems.isEmpty())) {
            return ResponseEntity.badRequest().build();
        }
        List<SalesData> salesData = getSalesDataService.retrieveSalesData(orderId, tempItems);
        if (salesData == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(salesData);
    }
}