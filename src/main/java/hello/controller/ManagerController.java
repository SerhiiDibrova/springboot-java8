package hello.controller;

import hello.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ManagerController {

    private final ManagerService managerService;
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/default-manager-id")
    public ResponseEntity<String> getDefaultManagerId(@RequestParam(required = false) String managerId) {
        if (managerId != null && !isValidManagerId(managerId)) {
            return ResponseEntity.badRequest().body("Invalid manager ID format");
        }
        
        String defaultManagerId = managerService.getDefaultManagerId(managerId);
        if (defaultManagerId == null) {
            logger.error("No default manager found for managerId: {}", managerId);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(defaultManagerId);
    }

    private boolean isValidManagerId(String managerId) {
        // Implement validation logic for managerId format
        return true; // Placeholder for actual validation
    }
}