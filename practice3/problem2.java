import java.util.Scanner;
import java.util.Vector;


class Person {
    private String name;
    private String address;
     public Person(String name, String address) {
        this.name = name;
        this.address = address;
     }

     public String getName() {
        return name;
     }

     public String getAdress() {
        return address;
     }
     public void setAddress(String address) {
        this.address = address;
     }
     public String toString() {
        return "Person[name = "  + name + ", address = " + address +"]";
     }
}

class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee){
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getFee() {
        return fee;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }

    public String toString(){
        return "Student [" + super.toString() + ", program = " + program + ", year = " + year + ", fee = " + fee + "]";
    }
} 
class Staff extends Person {
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public double getPay() {
        return pay;
    }
    public void setPay(double pay) {
        this.pay = pay;
    }
    public String toString() {
        return "Staff [" + super.toString() + ", school = " + school + ", pay = " + pay + "]";
    }
}


public class problem2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Person> people = new Vector<>();

        while (true) {

            System.out.println("1 - Add person");
            System.out.println("2 - Print all");
            System.out.println("3 - Exit");

            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.println("1 Person  2 Student  3 Staff");
                int type = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Address: ");
                String address = sc.nextLine();

                if (type == 1) {

                    people.add(new Person(name, address));

                } else if (type == 2) {

                    System.out.print("Program: ");
                    String program = sc.nextLine();

                    System.out.print("Year: ");
                    int year = sc.nextInt();

                    System.out.print("Fee: ");
                    double fee = sc.nextDouble();

                    people.add(new Student(name, address, program, year, fee));

                } else {

                    System.out.print("School: ");
                    String school = sc.nextLine();

                    System.out.print("Pay: ");
                    double pay = sc.nextDouble();

                    people.add(new Staff(name, address, school, pay));
                }

            }

            else if (choice == 2) {

                for (Person p : people) {
                    System.out.println(p);
                }

            }

            else {
                break;
            }
        }
    }
}