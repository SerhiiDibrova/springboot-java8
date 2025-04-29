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

    @GetMapping("/default-manager-id")
    public ResponseEntity<Integer> getDefaultManagerId(@RequestParam(required = false) Integer managerId) {
        Integer defaultManagerId;
        if (managerId == null) {
            defaultManagerId = managerService.getDefaultManagerId(null);
        } else {
            defaultManagerId = managerService.getDefaultManagerId(managerId);
        }
        if (defaultManagerId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(defaultManagerId);
    }
}