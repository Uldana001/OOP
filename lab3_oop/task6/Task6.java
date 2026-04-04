import java.util.ArrayList;
import java.util.List;

public class Task6 {

    interface Describable {
        String describe();
    }

    interface Trainable {
        void train(String skill);
        List<String> getSkills();
    }

    static class Person implements Comparable<Person>, Cloneable, Describable {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }

        public Person clone() throws CloneNotSupportedException {
            return (Person) super.clone();
        }

        public String describe() {
            return "I am " + name + " and I am " + age + " years old.";
        }

        public String toString() {
            return "Person[" + name + ", " + age + "]";
        }

        public boolean equals(Object o) {
            if (!(o instanceof Person)) return false;
            return name.equals(((Person) o).name);
        }
    }

    static class Pet implements Cloneable, Describable, Trainable {
        String name;
        String species;
        List<String> skills = new ArrayList<>();

        Pet(String name, String species) {
            this.name = name;
            this.species = species;
        }

        public void train(String skill) {
            skills.add(skill);
            System.out.println(name + " learned: " + skill);
        }

        public List<String> getSkills() {
            return skills;
        }

        public String describe() {
            return name + " is a " + species + " with " + skills.size() + " skills.";
        }

        public Pet clone() throws CloneNotSupportedException {
            Pet copy = (Pet) super.clone();
            copy.skills = new ArrayList<>(skills);
            return copy;
        }

        public String toString() {
            return "Pet[" + name + ", " + species + "]";
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("--- Person ---");
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 25);
        Person p3 = new Person("Charlie", 35);

        System.out.println(p1.describe());
        System.out.println(p2.describe());

        System.out.println("\n--- compareTo ---");
        System.out.println("Alice vs Bob: " + p1.compareTo(p2));
        System.out.println("Bob vs Charlie: " + p2.compareTo(p3));

        System.out.println("\n--- clone Person ---");
        Person cloned = p1.clone();
        System.out.println("Cloned: " + cloned);
        System.out.println("Same object? " + (cloned == p1));
        System.out.println("Equal? " + cloned.equals(p1));

        System.out.println("\n--- Pet ---");
        Pet pet = new Pet("Buddy", "Dog");
        System.out.println(pet.describe());

        System.out.println("\n--- train Pet ---");
        pet.train("sit");
        pet.train("shake");
        pet.train("roll over");
        System.out.println("Skills: " + pet.getSkills());
        System.out.println(pet.describe());

        System.out.println("\n--- clone Pet ---");
        Pet clonedPet = pet.clone();
        System.out.println("Cloned: " + clonedPet);
        System.out.println("Same object? " + (clonedPet == pet));
        System.out.println("Same skills list? " + (clonedPet.skills == pet.skills));
        System.out.println("Skills match? " + clonedPet.getSkills().equals(pet.getSkills()));
    }
}