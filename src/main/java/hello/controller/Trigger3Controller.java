

package hello.controller;

import hello.service.Trigger3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Trigger3Controller {

    private final Trigger3Service trigger3Service;
    private final Logger logger = LoggerFactory.getLogger(Trigger3Controller.class);

    public Trigger3Controller(Trigger3Service trigger3Service) {
        this.trigger3Service = trigger3Service;
    }

    @RequestMapping("/trigger3")
    @Transactional
    public void handleTrigger3() {
        trigger3Service.executeTrigger3();
    }
}