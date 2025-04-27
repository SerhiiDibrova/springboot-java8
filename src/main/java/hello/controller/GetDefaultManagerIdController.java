package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.service.GetDefaultManagerIdService;

@RestController
public class GetDefaultManagerIdController {

    @Autowired
    private GetDefaultManagerIdService getDefaultManagerIdService;

    @GetMapping("/getDefaultManagerId")
    public ResponseEntity<String> getDefaultManagerId(@RequestParam(required = false) String managerId) {
        String result = getDefaultManagerIdService.getDefaultManagerId(managerId);
        return ResponseEntity.ok(result);
    }
}