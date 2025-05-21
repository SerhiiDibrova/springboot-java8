package hello.model;

import hello.declaration.IAnimal;

public class Cat implements IAnimal {
    @Override
    public String Speak() {
        return "Meow";
    }
}