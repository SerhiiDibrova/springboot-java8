package hello.service;

public interface IAnimal {
    String Speak();
}

class Cat implements IAnimal {
    @Override
    public String Speak() {
        return "Meow";
    }
}

class Dog implements IAnimal {
    @Override
    public String Speak() {
        return "Woof";
    }
}