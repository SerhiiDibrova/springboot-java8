

package hello.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/proc11")
@Api(value = "proc11", description = "Proc11 API")
public class Proc11Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc11Controller.class);

    private final Proc11Service proc11Service;

    @Autowired
    public Proc11Controller(Proc11Service proc11Service) {
        this.proc11Service = proc11Service;
    }

    @RequestMapping(value = "/insertRecord", method = RequestMethod.POST)
    @ApiOperation(value = "Insert a new record into the table_11 table")
    public ResponseEntity<Void> insertRecord(
            @ApiParam(value = "Input parameter", required = true)
            @NotNull
            @RequestParam Integer input) {
        try {
            proc11Service.insertRecord(input);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Error inserting record", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}