package hello.service;

import java.util.Objects;

public class PostgresDsn {
    public static String build(String user, String password, String host, String path) {
        Objects.requireNonNull(user, "User cannot be null");
        Objects.requireNonNull(password, "Password cannot be null");
        Objects.requireNonNull(host, "Host cannot be null");
        Objects.requireNonNull(path, "Path cannot be null");
        
        String scheme = "postgresql";
        return String.format("%s://%s:%s@%s%s", scheme, user, password, host, path);
    }
}