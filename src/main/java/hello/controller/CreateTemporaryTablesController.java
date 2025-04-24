

package hello.controller;

import hello.service.SalesReportService;
import hello.service.TempItemService;
import hello.service.WarehouseReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateTemporaryTablesController {

    private static final Logger logger = LoggerFactory.getLogger(CreateTemporaryTablesController.class);

    private final TempItemService tempItemService;
    private final WarehouseReportService warehouseReportService;
    private final SalesReportService salesReportService;

    @Autowired
    public CreateTemporaryTablesController(TempItemService tempItemService, WarehouseReportService warehouseReportService, SalesReportService salesReportService) {
        this.tempItemService = tempItemService;
        this.warehouseReportService = warehouseReportService;
        this.salesReportService = salesReportService;
    }

    @PostMapping("/create-temporary-tables")
    public ResponseEntity<String> createTemporaryTables(@RequestBody String requestBody) {
        try {
            tempItemService.createTempItemTable();
            warehouseReportService.createWarehouseReportTable();
            salesReportService.createSalesReportTable();
            return ResponseEntity.status(HttpStatus.CREATED).body("Temporary tables created successfully");
        } catch (Exception e) {
            logger.error("Error creating temporary tables", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating temporary tables");
        }
    }
}