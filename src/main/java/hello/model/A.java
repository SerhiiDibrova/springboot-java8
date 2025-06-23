package hello.model;

public class HelloWorldModel {
    public String getHelloWorldMessage() {
        try {
            return "Hello, World!";
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }
}