package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.WarehouseReportService;

@RestController
@RequestMapping("/warehouse-report")
public class WarehouseReportController {

    @Autowired
    private WarehouseReportService warehouseReportService;

    @PostMapping("/insert")
    public ResponseEntity<String> insertWarehouseReport(@RequestBody String xmlData) {
        boolean success = warehouseReportService.insertReport(xmlData);
        if (success) {
            return ResponseEntity.ok("Warehouse report inserted successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to insert warehouse report.");
        }
    }
}