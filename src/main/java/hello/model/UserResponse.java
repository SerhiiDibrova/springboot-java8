package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("value")
    private String value;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("name")
    private String name;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}