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

    @GetMapping("/manager/default")
    public ResponseEntity<Long> getDefaultManagerId(@RequestParam(required = false) Long managerId) {
        if (managerId != null && managerId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        
        Long defaultManagerId = managerService.getDefaultManagerId(managerId);
        if (defaultManagerId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        return ResponseEntity.ok(defaultManagerId);
    }
}