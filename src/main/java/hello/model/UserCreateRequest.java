package hello.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserCreateRequest {
    
    @Email
    private String email;

    @NotBlank
    private String value;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}