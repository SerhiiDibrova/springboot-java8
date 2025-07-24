package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import hello.service.AbendProgramService;

@RestController
public class AbendProgramController {

    @Autowired
    private AbendProgramService abendProgramService;

    public ResponseEntity<Boolean> abendProgram() {
        try {
            boolean result = abendProgramService.abendProgram();
            return new ResponseEntity<>(result, result ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}