package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/api/sales-report/populate")
    public ResponseEntity<String> populateSalesReport(
            @NotNull @RequestParam Integer orderId,
            @RequestParam(required = false) Integer managerId,
            @NotNull @RequestParam String xmlData,
            @RequestParam(defaultValue = "false") Boolean isAuditNeeded) {
        try {
            salesReportService.populateSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok("Sales report populated successfully");
        } catch (SpecificServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        } finally {
            // Resource cleanup if necessary
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
    }
}