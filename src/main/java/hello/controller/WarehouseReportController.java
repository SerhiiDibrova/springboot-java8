package hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import hello.service.WarehouseReportService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;

@RestController
@RequestMapping("/warehouse-report")
public class WarehouseReportController {

    @Autowired
    private WarehouseReportService warehouseReportService;

    @PostMapping("/insert")
    public ResponseEntity<String> insertWarehouseReport(
            @RequestParam(required = false) String orderId,
            @RequestParam(required = false) String regionName,
            @RequestParam(required = false) String productCategory,
            @RequestParam(required = false) Integer stockLevel,
            @RequestParam(required = false) Double logisticsEfficiency) {
        
        if (orderId == null || regionName == null || productCategory == null || stockLevel == null || logisticsEfficiency == null) {
            return ResponseEntity.badRequest().body("Invalid input parameters");
        }

        boolean success = warehouseReportService.insertWarehouseReportData(orderId, regionName, productCategory, stockLevel, logisticsEfficiency);
        if (success) {
            return ResponseEntity.ok("Insertion successful");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insertion failed");
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
    }
}