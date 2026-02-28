import java.util.Scanner;

public class Problem1 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[10];
        int studentCount = 0;
        
        System.out.println("=== STUDENT MANAGEMENT SYSTEM ===\n");
        
        OUTER:
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add a new student");
            System.out.println("2. View all students");
            System.out.println("3. Find student by ID");
            System.out.println("4. Increment year for a student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    students[studentCount] = new Student(name, id);
                    System.out.println("Student added! Year: " + students[studentCount].getYear());
                    studentCount++;
                }
                case 2 -> {
                    System.out.println("\n--- ALL STUDENTS ---");
                    if (studentCount == 0) {
                        System.out.println("No students yet.");
                    } else {
                        for (int i = 0; i < studentCount; i++) {
                            System.out.println((i+1) + ". " + students[i]);
                        }
                    }
                }
                case 3 ->                     {
                        System.out.print("Enter student ID to find: ");
                        int searchId = scanner.nextInt();
                        boolean found = false;
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getId() == searchId) {
                                System.out.println("Found: " + students[i]);
                                found = true;
                                break;
                            }
                        }       if (!found) {
                            System.out.println("Student with ID " + searchId + " not found.");
                        }                          }
                case 4 ->                     {
                        System.out.print("Enter student ID to increment year: ");
                        int searchId = scanner.nextInt();
                        boolean found = false;
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getId() == searchId) {
                                System.out.println("Before: " + students[i]);
                                students[i].incrementYear();
                                System.out.println("After: " + students[i]);
                                found = true;
                                break;
                            }
                        }       if (!found) {
                            System.out.println("Student with ID " + searchId + " not found.");
                        }                          }
                case 5 -> {
                    System.out.println("Goodbye!");
                    break OUTER;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
        
        scanner.close();
    }
}

class Student {
    private String name;
    private int id;
    private int year;
    
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.year = 1;  
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public int getYear() {
        return year;
    }
    
    public void incrementYear() {
        year++;
        System.out.println(name + " is now in year " + year);
    }
    
    public String toString() {
        return name + " (ID: " + id + ") - Year " + year;
    }
}