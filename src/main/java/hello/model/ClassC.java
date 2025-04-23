package hello.model;

public class ClassC {
    public String method_c() {
        System.out.println("Method C executed");
        return "Method C executed";
    }

    public static void main(String[] args) {
        ClassC classC = new ClassC();
        System.out.println(classC.method_c());
        System.out.println("Main function executed");
    }
}