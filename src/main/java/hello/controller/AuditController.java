

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditController {

    private final AuditService auditService;

    @Autowired
    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/audit")
    public ResponseEntity<String> performAudit(@RequestParam("managerId") Long managerId, @RequestParam("isAuditNeeded") Boolean isAuditNeeded) {
        String result = auditService.performAudit(managerId, isAuditNeeded);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}