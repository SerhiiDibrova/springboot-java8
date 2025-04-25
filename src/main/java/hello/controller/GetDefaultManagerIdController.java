package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotBlank;

@RestController
public class GetDefaultManagerIdController {

    @Autowired
    private GetDefaultManagerIdService getDefaultManagerIdService;

    @GetMapping("/default-manager-id")
    public ResponseEntity<Long> getDefaultManagerId(@RequestParam @NotBlank String departmentId) {
        Long managerId = getDefaultManagerIdService.getDefaultManagerId(departmentId);
        return ResponseEntity.ok(managerId);
    }
}

package hello.service;

import org.springframework.stereotype.Service;

@Service
public class GetDefaultManagerIdService {

    public Long getDefaultManagerId(String departmentId) {
        // Implementation logic to retrieve the default manager ID based on departmentId
        return 1L; // Placeholder return value
    }
}