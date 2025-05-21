package hello.declaration;

public interface IAnimal {
    String Speak();
}

package hello.declaration;

public class Cat implements IAnimal {
    @Override
    public String Speak() {
        return "Meow";
    }
}