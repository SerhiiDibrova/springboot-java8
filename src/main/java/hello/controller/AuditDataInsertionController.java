package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AuditDataInsertionController {

    @Autowired
    private AuditDataInsertionService auditDataInsertionService;

    @PostMapping("/audit-data")
    public List<?> insertAuditData(@RequestBody ManagerIdRequest request) {
        if (request.getManagerId() == null || request.getManagerId().isEmpty()) {
            throw new IllegalArgumentException("Manager ID must not be null or empty");
        }
        return auditDataInsertionService.insertAuditData(request.getManagerId());
    }
}

class ManagerIdRequest {
    private String managerId;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
}