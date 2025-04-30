package hello.controller;

import hello.service.WarehouseReportService;
import hello.exception.ControllerAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouse-report")
public class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;

    @Autowired
    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @PostMapping("/populate")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> populateWarehouseReport() {
        try {
            warehouseReportService.populateWarehouseReport();
            return ResponseEntity.ok().build();
        } catch (DataInsertionException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Data insertion failed", e);
        }
    }
}