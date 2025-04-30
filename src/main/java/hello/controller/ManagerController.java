package hello.controller;

import hello.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Integer> getDefaultManagerId(@RequestParam(required = false) Integer managerId) {
        if (managerId == null) {
            return ResponseEntity.badRequest().build();
        }
        Integer defaultManagerId = managerService.getDefaultManagerId(managerId);
        if (defaultManagerId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(defaultManagerId);
    }
}