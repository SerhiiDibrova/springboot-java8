

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
public class Func3Controller {

    private static final Logger LOGGER = Logger.getLogger(Func3Controller.class.getName());

    @Autowired
    private Func3Service func3Service;

    @RequestMapping("/getName")
    public String getName(@Valid @RequestParam Integer id) {
        if (id == null) {
            LOGGER.severe("Input parameter id is null");
            throw new NullPointerException("Input parameter id is null");
        }
        if (func3Service == null) {
            LOGGER.severe("Func3Service instance is null");
            throw new NullPointerException("Func3Service instance is null");
        }
        try {
            return func3Service.getName(id);
        } catch (Exception e) {
            LOGGER.severe("Error occurred while calling Func3Service method: " + e.getMessage());
            throw e;
        }
    }
}