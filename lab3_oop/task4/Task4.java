import java.util.*;

public class Task4 {

    static class Person {
        protected String name;

        Person(String name) {
            this.name = name;
        }

        public String toString() {
            return "Person[" + name + "]";
        }

        public boolean equals(Object o) {
            if (!(o instanceof Person)) return false;
            return name.equals(((Person) o).name);
        }
    }

    static class Employee extends Person implements Comparable<Employee>, Cloneable {
        protected double salary;
        protected Date hireDate;
        protected String insuranceNumber;

        Employee(String name, double salary, Date hireDate, String insuranceNumber) {
            super(name);
            this.salary = salary;
            this.hireDate = hireDate;
            this.insuranceNumber = insuranceNumber;
        }

        public int compareTo(Employee other) {
            return Double.compare(this.salary, other.salary);
        }

        public String toString() {
            return "Employee[" + name + ", $" + salary + ", hired: " + hireDate + "]";
        }

        public boolean equals(Object o) {
            if (!(o instanceof Employee)) return false;
            Employee e = (Employee) o;
            return name.equals(e.name) && insuranceNumber.equals(e.insuranceNumber);
        }

        public Employee clone() throws CloneNotSupportedException {
            Employee copy = (Employee) super.clone();
            copy.hireDate = (Date) hireDate.clone();
            return copy;
        }

        static Comparator<Employee> byName() {
            return Comparator.comparing(e -> e.name);
        }

        static Comparator<Employee> byHireDate() {
            return Comparator.comparing(e -> e.hireDate);
        }
    }

    static class Manager extends Employee {
        private Vector<Employee> team = new Vector<>();
        private double bonus;

        Manager(String name, double salary, Date hireDate, String insuranceNumber, double bonus) {
            super(name, salary, hireDate, insuranceNumber);
            this.bonus = bonus;
        }

        public void addTeamMember(Employee e) {
            team.add(e);
        }

        public int compareTo(Employee other) {
            int cmp = super.compareTo(other);
            if (cmp == 0 && other instanceof Manager) {
                return Double.compare(this.bonus, ((Manager) other).bonus);
            }
            return cmp;
        }

        public String toString() {
            return "Manager[" + name + ", $" + salary + ", bonus: $" + bonus + ", team size: " + team.size() + "]";
        }

        public boolean equals(Object o) {
            if (!(o instanceof Manager)) return false;
            Manager m = (Manager) o;
            return name.equals(m.name) && insuranceNumber.equals(m.insuranceNumber);
        }

        public Manager clone() throws CloneNotSupportedException {
            Manager copy = (Manager) super.clone();
            copy.team = new Vector<>(team);
            return copy;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Date date1 = new GregorianCalendar(2020, Calendar.JANUARY, 10).getTime();
        Date date2 = new GregorianCalendar(2018, Calendar.MARCH, 5).getTime();
        Date date3 = new GregorianCalendar(2022, Calendar.JUNE, 1).getTime();

        Employee e1 = new Employee("Alice", 50000, date1, "INS001");
        Employee e2 = new Employee("Bob", 70000, date2, "INS002");
        Employee e3 = new Employee("Charlie", 40000, date3, "INS003");

        Manager m1 = new Manager("Diana", 90000, date1, "INS004", 15000);
        Manager m2 = new Manager("Eve", 90000, date2, "INS005", 20000);

        m1.addTeamMember(e1);
        m1.addTeamMember(e2);

        System.out.println("--- toString ---");
        System.out.println(e1);
    }
}