package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.WarehouseReportService;
import hello.dto.WarehouseReportDTO;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WarehouseReportController {

    @Autowired
    private WarehouseReportService warehouseReportService;

    @PostMapping("/warehouse-report")
    public ResponseEntity<String> insertWarehouseReport(@RequestBody List<WarehouseReportDTO> reportData) {
        warehouseReportService.insertWarehouseReportData(reportData);
        return ResponseEntity.ok("Report inserted successfully");
    }
}