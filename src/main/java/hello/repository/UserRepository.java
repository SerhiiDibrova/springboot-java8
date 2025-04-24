package hello.repository;

import model.User;
import java.util.*;

public class UserRepository {
    private static final List<User> db = Arrays.asList(
    );

    public Optional<User> getById(int id) {
        return db.stream().filter(user -> user.getId() == id).findFirst();
    }
}
