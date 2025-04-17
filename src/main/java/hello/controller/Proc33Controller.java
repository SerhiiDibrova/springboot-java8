

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.service.Proc33Service;

@RestController
@RequestMapping(value = "/proc33", method = RequestMethod.GET)
public class Proc33Controller {

    @Autowired
    private Proc33Service proc33Service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> execute(@RequestParam Integer input) {
        try {
            proc33Service.execute(input);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}