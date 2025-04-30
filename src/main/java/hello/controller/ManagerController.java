package hello.controller;

import hello.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/manager/default")
    public ResponseEntity<Integer> getDefaultManagerId(@RequestParam(required = false) Integer managerId) {
        if (managerId != null) {
            return ResponseEntity.ok(managerId);
        }
        try {
            Integer defaultManagerId = managerService.getDefaultManagerId();
            return ResponseEntity.ok(defaultManagerId);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body("Default manager not found");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid request parameters");
        }
    }
}