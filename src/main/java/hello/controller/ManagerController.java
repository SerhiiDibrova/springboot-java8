package hello.controller;

import hello.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/default-manager-id")
    public ResponseEntity<String> getDefaultManagerId(@RequestParam(required = false) String managerId) {
        try {
            String defaultManagerId = (managerId != null) ? managerId : managerService.getDefaultManagerId();
            return ResponseEntity.ok(defaultManagerId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving default manager ID");
        }
    }
}