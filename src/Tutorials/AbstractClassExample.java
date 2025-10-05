package Tutorials;

abstract class Animal {
    abstract void sound(); // must be implemented
    void eat() { System.out.println("Eating..."); } // concrete method
}

class Dog extends Animal {
    void sound() { System.out.println("Woof!"); }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound(); // Woof!
        a.eat();   // Eating...
    }
}
