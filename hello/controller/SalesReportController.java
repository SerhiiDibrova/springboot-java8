package hello.controller;

import hello.service.SalesReportService;
import hello.dto.AuditDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sales-report")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/insert-audit-data")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<List<AuditDataDTO>> insertAuditData(@RequestParam @Valid Integer managerId) {
        if (managerId == null || managerId <= 0) {
            return ResponseEntity.badRequest().body(List.of(new AuditDataDTO("Invalid managerId")));
        }
        List<AuditDataDTO> auditDataList = salesReportService.insertAuditData(managerId);
        if (auditDataList == null) {
            return ResponseEntity.status(500).body(List.of(new AuditDataDTO("Internal server error")));
        }
        return ResponseEntity.ok(auditDataList);
    }
}

package hello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}