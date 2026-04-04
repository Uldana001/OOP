interface Drawable {
    void draw();
    void resize(double factor);
}

class Circle implements Drawable {
    double radius;
    Circle(double r) { this.radius = r; }

    public void draw() {
        System.out.println("Drawing circle r=" + radius);
    }
    public void resize(double factor) {
        radius *= factor;
    }
}

class TextBox implements Drawable {
    String text;
    TextBox(String t) { this.text = t; }

    public void draw() {
        System.out.println("Drawing textbox: " + text);
    }
    public void resize(double factor) {
        System.out.println("Resizing text by " + factor);
    }
}

abstract class Animal {
    String name;          
    Animal(String name) { this.name = name; }

    void breathe() {      
        System.out.println(name + " is breathing");
    }

    abstract void makeSound(); 
}

class Dog extends Animal {
    Dog(String name) { super(name); }
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

class Cat extends Animal {
    Cat(String name) { super(name); }
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}
public class Task1 {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.draw();

        Dog d = new Dog("Rex");
        d.makeSound();
    }
}