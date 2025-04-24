

package hello.controller;

import hello.dto.WarehouseReportDTO;
import hello.service.WarehouseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;

    @Autowired
    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @GetMapping("/warehouse-report")
    public List<WarehouseReportDTO> getWarehouseReport() {
        return warehouseReportService.generateWarehouseReport();
    }
}