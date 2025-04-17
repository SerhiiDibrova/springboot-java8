

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;

    @Autowired
    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @GetMapping("/warehouse-report")
    public Map<String, Object> getWarehouseReport() {
        return warehouseReportService.generateWarehouseReport();
    }
}