import java.util.Scanner;

public class GradeCalculator {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your score (0-100): ");
        int score = input.nextInt();
        
        String grade;
        
        if (score >= 95 && score <= 100) {
            grade = "A";
        } else if (score >= 90 && score < 95) {
            grade = "A-";
        } else if (score >= 85 && score < 90) {
            grade = "B+";
        } else if (score >= 80 && score < 85) {
            grade = "B";
        } else if (score >= 75 && score < 80) {
            grade = "B-";
        } else if (score >= 70 && score < 75) {
            grade = "C+";
        } else if (score >= 65 && score < 70) {
            grade = "C";
        } else if (score >= 60 && score < 65) {
            grade = "C-";
        } else if (score >= 55 && score < 60) {
            grade = "D+";
        } else if (score >= 50 && score < 55) {
            grade = "D";
        } else if (score >= 0 && score < 50) {
            grade = "F";
        } else {
            grade = "Invalid score";
        }
        
        System.out.println("Your grade: " + grade);
        
        input.close();
    }
}