

package hello.controller;

import hello.service.GetSalesDataService;
import hello.model.SalesData;
import hello.model.SalesReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetSalesDataController {

    private final GetSalesDataService getSalesDataService;
    private static final Logger logger = LoggerFactory.getLogger(GetSalesDataController.class);

    @Autowired
    public GetSalesDataController(GetSalesDataService getSalesDataService) {
        this.getSalesDataService = getSalesDataService;
    }

    @GetMapping("/sales-data")
    public ResponseEntity<SalesReport> getSalesData() {
        try {
            SalesData salesData = getSalesDataService.getSalesData();
            if (salesData == null || salesData.isEmpty()) {
                logger.warn("No sales data found");
                return ResponseEntity.noContent().build();
            }
            SalesReport salesReport = new SalesReport(salesData);
            return ResponseEntity.ok(salesReport);
        } catch (Exception e) {
            logger.error("Error retrieving sales data", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}