

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling requests related to sales reports.
 */
@RestController
public class SalesReportController {

    private final GetSalesReportService getSalesReportService;

    @Autowired
    public SalesReportController(GetSalesReportService getSalesReportService) {
        this.getSalesReportService = getSalesReportService;
    }

    /**
     * Handles GET requests to retrieve sales report data.
     * 
     * @return a ResponseEntity containing the sales report data
     */
    @GetMapping("/sales-report")
    public ResponseEntity<SalesReport> retrieveSalesReport() {
        try {
            SalesReport salesReport = getSalesReportService.getSalesReport();
            return ResponseEntity.ok(salesReport);
        } catch (Exception e) {
            // Handle exception and return a corresponding HTTP response
            return ResponseEntity.internalServerError().build();
        }
    }
}