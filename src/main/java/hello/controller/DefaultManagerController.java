package hello.controller;

import hello.service.DefaultManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultManagerController {

    @Autowired
    private DefaultManagerService defaultManagerService;

    @GetMapping("/default-manager")
    public ResponseEntity<?> getDefaultManagerId(@RequestParam String managerId) {
        try {
            String defaultManagerId = defaultManagerService.getDefaultManagerId(managerId);
            return ResponseEntity.ok(defaultManagerId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving default manager ID");
        }
    }
}