package hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import hello.service.WarehouseReportService;

@RestController
@RequestMapping("/warehouse-report")
public class WarehouseReportController {

    @Autowired
    private WarehouseReportService warehouseReportService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertWarehouseReport(
            @RequestParam(required = false) String filterParam1,
            @RequestParam(required = false) String filterParam2) {
        boolean success = warehouseReportService.insertWarehouseReportData(filterParam1, filterParam2);
        if (success) {
            return ResponseEntity.ok("Insertion successful");
        } else {
            return ResponseEntity.status(500).body("Insertion failed");
        }
    }
}