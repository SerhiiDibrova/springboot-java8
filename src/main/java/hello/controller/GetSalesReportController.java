

package hello.controller;

import hello.dto.SalesReportDTO;
import hello.service.GetSalesReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetSalesReportController {

    private final GetSalesReportService getSalesReportService;

    public GetSalesReportController(GetSalesReportService getSalesReportService) {
        this.getSalesReportService = getSalesReportService;
    }

    @GetMapping("/sales-report")
    public ResponseEntity<List<SalesReportDTO>> getSalesReport() {
        List<SalesReportDTO> salesReport = getSalesReportService.getSalesReport();
        return ResponseEntity.ok(salesReport);
    }
}