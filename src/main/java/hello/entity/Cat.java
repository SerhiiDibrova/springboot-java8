package hello.entity;

import hello.interfaces.IAnimal;

public class Cat implements IAnimal {
    @Override
    public String Speak() {
        return "Meow";
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.Speak());
    }
}