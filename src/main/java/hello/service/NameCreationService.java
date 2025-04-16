

package hello.service;

import org.springframework.stereotype.Service;
import hello.model.Name;

@Service
public class NameCreationService {

    public void createNameRecord(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("Input parameter cannot be null");
        }
        // Create a new Name object
        Name name = new Name();
        // Set the input value to the Name object
        name.setValue(input.toString());
        // Save the Name object to the database or perform other necessary actions
        // For demonstration purposes, this step is omitted
    }
}