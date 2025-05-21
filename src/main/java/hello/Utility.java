package hello;

public class Utility {
    public static String Prepare(String input) {
        if (input == null) {
            return "";
        }
        return input.toUpperCase();
    }
}