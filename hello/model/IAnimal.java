package hello.model;

public interface IAnimal {
    String speak();
}

class Cat implements IAnimal {
    @Override
    public String speak() {
        return "Meow";
    }
}

class Dog implements IAnimal {
    @Override
    public String speak() {
        return "Bark";
    }
}