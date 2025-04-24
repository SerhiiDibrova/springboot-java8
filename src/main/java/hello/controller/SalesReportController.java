

package hello.controller;

import hello.dto.SalesReportDTO;
import hello.service.SalesReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SalesReportController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesReportController.class);
    private final SalesReportService salesReportService;

    @Autowired
    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    /**
     * Retrieves the sales report based on the provided parameters.
     *
     * @param orderId        The ID of the order.
     * @param managerId     The ID of the manager.
     * @param xmlData        The XML data.
     * @param isAuditNeeded  A boolean indicating whether an audit is needed.
     * @return The sales report as a response.
     */
    @GetMapping("/sales-report")
    public ResponseEntity<SalesReportDTO> getSalesReport(
            @Valid @RequestParam("orderId") Long orderId,
            @Valid @RequestParam("managerId") Long managerId,
            @Valid @RequestParam("xmlData") String xmlData,
            @Valid @RequestParam("isAuditNeeded") Boolean isAuditNeeded) {
        LOGGER.info("Received request to retrieve sales report for order ID: {}, manager ID: {}, xml data: {}, is audit needed: {}", orderId, managerId, xmlData, isAuditNeeded);
        try {
            SalesReportDTO salesReportDTO = salesReportService.generateSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            LOGGER.info("Sales report generated successfully.");
            return ResponseEntity.ok(salesReportDTO);
        } catch (Exception e) {
            LOGGER.error("Error generating sales report: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}