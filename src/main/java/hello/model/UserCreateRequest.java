package hello.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserCreateRequest {
    
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String description;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}