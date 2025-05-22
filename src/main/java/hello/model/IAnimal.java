package hello.model;

public interface IAnimal {
    String Speak();
}

package hello.model;

public class Dog implements IAnimal {
    @Override
    public String Speak() {
        return "Woof";
    }
}

package hello.model;

public class Cat implements IAnimal {
    @Override
    public String Speak() {
        return "Meow";
    }
}