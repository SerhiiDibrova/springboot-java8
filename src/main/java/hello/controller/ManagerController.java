package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.service.ManagerService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/default-id")
    public ResponseEntity<String> getDefaultManagerId(@RequestParam(required = false) String managerId) {
        if (managerId != null && !isValidManagerId(managerId)) {
            return ResponseEntity.badRequest().body("Invalid manager ID");
        }
        String defaultManagerId = managerId != null ? managerId : managerService.getDefaultManagerId();
        return ResponseEntity.ok(defaultManagerId);
    }

    private boolean isValidManagerId(String managerId) {
        // Implement validation logic for managerId
        return true; // Placeholder for actual validation
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}