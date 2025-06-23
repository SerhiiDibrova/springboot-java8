package hello.model;

public class B {
    public String method_b() {
        return "Hello from method_b";
    }

    public String method_c() {
        String result = method_b();
        System.out.println(result);
        return result;
    }
}