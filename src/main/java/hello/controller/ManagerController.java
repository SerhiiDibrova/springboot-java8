package hello.controller;

import hello.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/default-manager-id")
    public ResponseEntity<?> getDefaultManagerId(@RequestParam(required = false) Integer managerId) {
        if (managerId != null && managerId < 0) {
            return ResponseEntity.badRequest().body("Invalid managerId provided.");
        }
        Integer defaultManagerId = managerService.getDefaultManagerId(managerId);
        if (defaultManagerId != null) {
            return ResponseEntity.ok(defaultManagerId);
        } else {
            return ResponseEntity.status(404).body("No manager found for the provided managerId.");
        }
    }
}