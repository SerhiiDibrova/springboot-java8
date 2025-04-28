package hello.model;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class UserDTO {
    private int id;
    private String name;

    // Constructors
    public UserDTO() {}

    public UserDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
