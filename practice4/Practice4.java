public class Practice4 {

    interface CanHavePizza {
        void eatPizza();
    }

    interface CanHaveRetake {
        void takeRetake();
    }

    interface CanHaveParty {
        void move();
        void dance();
    }

    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    static class Person {
        String name;
        String cardNumber;

        Person(String name, String cardNumber) {
            this.name = name;
            this.cardNumber = cardNumber;
        }

        public String toString() {
            return name;
        }
    }

    static class Cat extends Animal implements CanHavePizza {
        String furColor;

        Cat(String name, String furColor) {
            super(name);
            this.furColor = furColor;
        }

        public void eatPizza() {
            System.out.println(name + " the " + furColor + " cat is eating pizza... purrfect!");
        }
    }

    static class Student extends Person implements CanHavePizza, CanHaveRetake, CanHaveParty {
        String major;
        double gpa;

        Student(String name, String cardNumber, String major, double gpa) {
            super(name, cardNumber);
            this.major = major;
            this.gpa = gpa;
        }

        public void eatPizza() {
            System.out.println(name + " the " + major + " student is eating pizza after exams!");
        }

        public void takeRetake() {
            System.out.println(name + " is taking a retake exam. Should have studied more!");
        }

        public void move() {
            System.out.println(name + " is moving to the party!");
        }

        public void dance() {
            System.out.println(name + " is dancing all night!");
        }
    }

    static class Restaurant {
        String name;

        Restaurant(String name) {
            this.name = name;
        }

        boolean servePizza(CanHavePizza eater) {
            System.out.println("\n" + name + " is serving pizza to: " + eater);
            eater.eatPizza();

            if (eater instanceof Person) {
                Person p = (Person) eater;
                System.out.println("Processing payment for card: " + p.cardNumber);
                return true;
            }

            if (eater instanceof Cat) {
                System.out.println("No payment needed — cats eat for free!");
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {

        Restaurant delPapa = new Restaurant("Del Papa");

        Cat blackCat = new Cat("Shadow", "black");
        Cat orangeCat = new Cat("Garfield", "orange");
        Student student1 = new Student("Alice", "CARD-001", "Computer Science", 3.8);
        Student student2 = new Student("Bob", "CARD-002", "Mathematics", 3.2);

        System.out.println(" Serving Pizza ");
        delPapa.servePizza(blackCat);
        delPapa.servePizza(orangeCat);
        delPapa.servePizza(student1);
        delPapa.servePizza(student2);

        System.out.println("\n Student Extra Activities ");
        student1.takeRetake();
        student2.move();
        student2.dance();

        System.out.println("\n CanHavePizza reference ");
        CanHavePizza eater = new Cat("Whiskers", "white");
        eater.eatPizza();
    }
}