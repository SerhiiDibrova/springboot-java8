package hello.controller;

import hello.service.WarehouseReportService;
import hello.model.TempItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse-report")
public class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;

    @Autowired
    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> insertWarehouseReport(@RequestBody List<TempItem> tempItems) {
        warehouseReportService.insertWarehouseReport(tempItems);
        return ResponseEntity.ok().build();
    }
}