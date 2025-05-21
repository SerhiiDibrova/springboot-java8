package hello.service;

public class Utility {
    public static String prepare(String input) {
        if (input == null) {
            return "";
        }
        return input.toUpperCase();
    }
}