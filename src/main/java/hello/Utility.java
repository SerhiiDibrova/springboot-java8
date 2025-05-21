package hello;

public class Utility {
    public static String prepare(String input) {
        return input != null ? input.toUpperCase() : null;
    }
}