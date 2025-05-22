package hello.service;

public interface Animal {
    String speak();
}

package hello.service;

public class Dog implements Animal {
    @Override
    public String speak() {
        return "Woof!";
    }
}

package hello.service;

public class Cat implements Animal {
    @Override
    public String speak() {
        return "Meow!";
    }
}