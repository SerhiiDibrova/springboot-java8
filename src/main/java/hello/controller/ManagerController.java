package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.service.ManagerService;
import hello.dto.ManagerIdDTO;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/default-manager-id")
    public ResponseEntity<ManagerIdDTO> getDefaultManagerId(@RequestParam(required = false) Integer managerId) {
        ManagerIdDTO managerIdDTO = managerService.getDefaultManagerId(managerId);
        return ResponseEntity.ok(managerIdDTO);
    }
}