package hello.controller;

import hello.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    private final ManagerService managerService;
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/api/managers/default-id")
    public ResponseEntity<Integer> getDefaultManagerId(@RequestParam(required = false) Integer managerId) {
        try {
            Integer result = managerService.getDefaultManagerId(managerId);
            if (result == null) {
                logger.warn("No default manager found for managerId: {}", managerId);
                return ResponseEntity.status(404).body(null);
            }
            logger.info("Default manager ID retrieved: {}", result);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Error retrieving default manager ID", e);
            return ResponseEntity.status(500).body(null);
        }
    }
}