
class Animal {

    String name;

     Animal() {
        System.out.println("Animal created");
     }

     Animal(String name) {
        this.name = name;
     }

     void makeSound() {
        System.out.println("Animal makes a sound");
     }

     void eat(String food) {
        System.out.println("Animal eats " + food);
     }
     void eat() {
        System.out.println("Animal eats food");
     }
}

class Cat extends Animal {
    Cat() {
        super();
    }
    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Cat says: Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat c = new Cat("Tom");

        c.makeSound(); // overriding
        c.eat(); // overloading
        c.eat("fish"); // overloading
    }
}