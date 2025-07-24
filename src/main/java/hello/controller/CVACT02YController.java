package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hello.service.CVACT02YService;
import hello.model.CardRecord;

@RestController
public class CVACT02YController {

    private final CVACT02YService cvact02yService;

    @Autowired
    public CVACT02YController(CVACT02YService cvact02yService) {
        this.cvact02yService = cvact02yService;
    }

    @PostMapping("/validateCardRecord")
    public boolean validateCardRecord(@RequestBody CardRecord cardRecord) {
        return cvact02yService.validateCardRecord(cardRecord);
    }
}