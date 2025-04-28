package hello.model;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String email;
    private String name;
    private String value;
}