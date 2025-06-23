package hello.model;

public class UserType {
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";
    public static final String ALL = "ALL";

    public boolean method_a() {
        try {
            return this != null;
        } catch (Exception e) {
            return false;
        }
    }
}