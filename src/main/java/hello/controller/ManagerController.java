package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.service.ManagerService;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/default-manager-id")
    public ResponseEntity<Integer> getDefaultManagerId(@RequestParam(required = false) Integer managerId) {
        Integer defaultManagerId = managerService.getDefaultManagerId(managerId);
        return ResponseEntity.ok(defaultManagerId);
    }
}