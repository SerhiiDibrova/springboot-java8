

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for Proc14 functionality.
 */
@RestController
public class Proc14Controller {

    private final Proc14Service proc14Service;

    /**
     * Constructs a new Proc14Controller instance.
     * 
     * @param proc14Service the Proc14Service instance to be used
     */
    @Autowired
    public Proc14Controller(Proc14Service proc14Service) {
        this.proc14Service = proc14Service;
    }

    /**
     * Retrieves a name from the table_14 table based on the input ID and returns it as a response to the REST request.
     * 
     * @param id the ID to retrieve the name for
     * @return the retrieved name
     */
    @RequestMapping(method = RequestMethod.GET, path = "/name")
    public String getName(@RequestParam(required = true) Integer id) {
        try {
            return proc14Service.getName(id);
        } catch (Exception e) {
            // Handle the exception, for example, by logging it and returning an error message
            return "Error: " + e.getMessage();
        }
    }
}