package hello.service;

import org.springframework.stereotype.Service;
import hello.model.B;

import java.util.logging.Logger;

/**
 * Service class for demonstrating the usage of method_b from the B class.
 */
@Service
public class BService {

    private final B b;
    private static final Logger LOGGER = Logger.getLogger(BService.class.getName());

    /**
     * Constructor for the BService class.
     * 
     * @param b instance of the B class
     */
    public BService(B b) {
        this.b = b;
    }

    /**
     * Method to demonstrate the usage of method_b from the B class.
     * 
     * @return result of method_b
     */
    public String methodBUsage() {
        try {
            return b.method_b();
        } catch (Exception e) {
            LOGGER.severe("Error occurred while calling method_b: " + e.getMessage());
            return "Error occurred while calling method_b";
        }
    }
}