package hello.model;

import java.util.List;
import javax.validation.constraints.NotNull;

public class UserListResponse {
    @NotNull
    private List<User> users;
    private int totalCount;

    public UserListResponse(@NotNull List<User> users, int totalCount) {
        this.users = users;
        this.totalCount = totalCount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(@NotNull List<User> users) {
        this.users = users;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}