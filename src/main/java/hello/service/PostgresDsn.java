package hello.service;

public class PostgresDsn {
    public static String build(String scheme, String user, String password, String host, String path) {
        return String.format("%s://%s:%s@%s/%s", scheme, user, password, host, path);
    }
}