package hello.model;

import java.util.List;

public class UserListResponse {
    private List<User> users;
    private int totalCount;

    public UserListResponse(List<User> users, int totalCount) {
        this.users = users;
        this.totalCount = totalCount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}