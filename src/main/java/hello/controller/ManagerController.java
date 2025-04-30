package hello.controller;

import hello.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/default-manager-id")
    public ResponseEntity<Integer> getDefaultManagerId(@RequestParam(required = false) Integer managerId) {
        try {
            Integer defaultManagerId = managerService.getDefaultManagerId(managerId);
            if (defaultManagerId == null) {
                return ResponseEntity.status(404).body(null);
            }
            return ResponseEntity.ok(defaultManagerId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}