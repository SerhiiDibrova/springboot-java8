package hello.service;

public interface IAnimal {
    String Speak();
}

public class Dog implements IAnimal {
    public String Speak() {
        return "Woof";
    }
}

public class AnimalService {
    private IAnimal _animal;

    public AnimalService(IAnimal animal) {
        _animal = animal;
    }

    public String MakeSound() {
        if (_animal == null) {
            throw new NullPointerException("Animal not initialized");
        }
        return _animal.Speak();
    }
}