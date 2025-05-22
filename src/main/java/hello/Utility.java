package hello;

public class Utility {
    public static String Prepare(String input) {
        return (input != null) ? input.toUpperCase() : null;
    }
}