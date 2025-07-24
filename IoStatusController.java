package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IoStatusController {

    private final com.example.IoStatusDisplayService ioStatusDisplayService;

    @Autowired
    public IoStatusController(com.example.IoStatusDisplayService ioStatusDisplayService) {
        this.ioStatusDisplayService = ioStatusDisplayService;
    }

    @GetMapping("/io-status")
    public ResponseEntity<String> displayIoStatus(@RequestParam(required = false) String ioStatus) {
        try {
            if (ioStatus == null) {
                ioStatus = "";
            }
            String status = ioStatusDisplayService.displayIoStatus(ioStatus);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}