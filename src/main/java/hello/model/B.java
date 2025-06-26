package hello.model;

public class B {
    public String method_b() {
        try {
            return "Hello from method_b";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class C {
    private B b;

    public C(B b) {
        this.b = b;
    }

    public String method_c() {
        try {
            return b.method_b();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}