

package hello.controller;

import hello.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class AuditController {

    private final AuditService auditService;

    @Autowired
    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/audit")
    public AuditData performAudit(@RequestParam Long managerId, @RequestParam boolean isAuditNeeded) {
        if (managerId == null) {
            throw new NullPointerException("Manager ID cannot be null");
        }
        return auditService.performAudit(managerId, isAuditNeeded);
    }
}