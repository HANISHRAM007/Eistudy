// Prototype Interface
abstract class Animal implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract void makeSound();
}

// Concrete Prototypes
class Dog extends Animal {
    public Dog() {
        setName("Dog");
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    public Dog clone() {
        try {
            return (Dog) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class Cat extends Animal {
    public Cat() {
        setName("Cat");
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    public Cat clone() {
        try {
            return (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Client
public class PrototypePatternDemo {
    public static void main(String[] args) {
        Dog originalDog = new Dog();
        Dog clonedDog = originalDog.clone();
        System.out.println("Animal : " + clonedDog.getName());
        clonedDog.makeSound();

        Cat originalCat = new Cat();
        Cat clonedCat = originalCat.clone();
        System.out.println("Animal : " + clonedCat.getName());
        clonedCat.makeSound();
    }
}
