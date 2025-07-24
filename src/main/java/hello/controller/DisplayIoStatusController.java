package hello.controller;

import hello.service.DisplayIoStatusService;
import hello.model.IoStatus;
import hello.model.IoStatus04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
public class DisplayIoStatusController {

    private final DisplayIoStatusService displayIoStatusService;
    private static final Logger logger = Logger.getLogger(DisplayIoStatusController.class.getName());

    @Autowired
    public DisplayIoStatusController(DisplayIoStatusService displayIoStatusService) {
        this.displayIoStatusService = displayIoStatusService;
    }

    @GetMapping("/display-io-status")
    @PreAuthorize("hasAuthority('DISPLAY_IO_STATUS')")
    public ResponseEntity<IoStatus04> displayIoStatus(@Valid @RequestParam IoStatus ioStatus, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.severe("Validation failed: " + bindingResult.getAllErrors());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (!ioStatus.getIoStat1().matches("\\d+") && !ioStatus.getIoStat1().equals("9")) {
            logger.severe("IO-STAT1 is not numeric or '9': " + ioStatus.getIoStat1());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            IoStatus04 ioStatus04 = displayIoStatusService.displayIoStatus(ioStatus);
            return ResponseEntity.status(HttpStatus.OK).body(ioStatus04);
        } catch (Exception e) {
            logger.severe("Server error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}