package hello.model;

import java.util.List;
import java.util.Objects;

public class UserListResponse {
    private List<UserDTO> users;

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        if (users == null || users.isEmpty()) {
            throw new IllegalArgumentException("Users list cannot be null or empty");
        }
        this.users = users;
    }
}