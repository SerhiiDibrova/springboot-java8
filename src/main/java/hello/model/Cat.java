package hello.model;

import hello.interfaces.IAnimal;

public class Cat implements IAnimal {
    @Override
    public String Speak() {
        return "Meow";
    }
}