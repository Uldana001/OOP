import java.util.ArrayList;
import java.util.Scanner;

public class problem4 {
    
    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();
        gradeBook.run();
    }
}

class Course {
    private String code;
    private String name;
    private String description;
    private int credits;
    private String prerequisites;
    
    public Course() {
        this.code = "CS101";
        this.name = "Programming";
        this.description = "Intro to Programming";
        this.credits = 3;
        this.prerequisites = "None";
    }
    
    @Override
    public String toString() {
        return code + ": " + name;
    }
}

class Student {
    private String name;
    private int id;
    private double grade;
    private static int nextId = 1;
    
    public Student(String name) {
        this.name = name;
        this.id = nextId++;
        this.grade = 0;
    }
    
    public String getName() { return name; }
    public int getId() { return id; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
    
    @Override
    public String toString() {
        return name + " (ID: " + id + ") - Grade: " + grade;
    }
}

class GradeBook {
    private Course course;
    private ArrayList<Student> students;
    private Scanner scanner;
    
    public GradeBook() {
        this.course = new Course();
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        addSampleStudents();
    }
    
    private void addSampleStudents() {
        students.add(new Student("Student A"));
        students.add(new Student("Student B"));
        students.add(new Student("Student C"));
        students.add(new Student("Student D"));
        students.add(new Student("Student E"));
        students.add(new Student("Student F"));
        students.add(new Student("Student G"));
        students.add(new Student("Student H"));
        students.add(new Student("Student I"));
        students.add(new Student("Student J"));
    }
    
    public void run() {
        displayMessage();
        inputGrades();
        displayGradeReport();
    }
    
    public void displayMessage() {
        System.out.println("Welcome to the grade book for " + course + "!");
        System.out.println();
    }
    
    public void inputGrades() {
        System.out.println("Please, input grades for students:");
        for (Student s : students) {
            while (true) {
                System.out.print(s.getName() + ": ");
                try {
                    double grade = Double.parseDouble(scanner.nextLine());
                    if (grade >= 0 && grade <= 100) {
                        s.setGrade(grade);
                        break;
                    } else {
                        System.out.println("Grade must be 0-100");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number!");
                }
            }
        }
    }
    
    public void displayGradeReport() {
        if (students.isEmpty()) return;
        
        double sum = 0;
        for (Student s : students) {
            sum += s.getGrade();
        }
        double avg = sum / students.size();
        System.out.printf("\nClass average is %.2f.\n", avg);
        
        Student lowest = students.get(0);
        Student highest = students.get(0);
        for (Student s : students) {
            if (s.getGrade() < lowest.getGrade()) lowest = s;
            if (s.getGrade() > highest.getGrade()) highest = s;
        }
        
        System.out.println("Lowest grade is " + lowest.getGrade() + 
                         " (" + lowest.getName() + ", id: " + lowest.getId() + ").");
        System.out.println("Highest grade is " + highest.getGrade() + 
                         " (" + highest.getName() + ", id: " + highest.getId() + ").");
        
        System.out.println("\nGrades distribution:");
        int[] ranges = new int[11];
        for (Student s : students) {
            int g = (int)s.getGrade();
            if (g == 100) ranges[10]++;
            else ranges[g/10]++;
        }
        
        String[] labels = {"00-09:", "10-19:", "20-29:", "30-39:", "40-49:",
                          "50-59:", "60-69:", "70-79:", "80-89:", "90-99:", "100:"};
        
        for (int i = 0; i < 11; i++) {
            System.out.print(labels[i] + " ");
            for (int j = 0; j < ranges[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    @Override
    public String toString() {
        return "GradeBook for " + course + " with " + students.size() + " students";
    }
}