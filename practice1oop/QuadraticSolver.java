import java.util.Scanner;

public class QuadraticSolver {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Solve: ax² + bx + c = 0");
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        
        System.out.print("Enter c: ");
        double c = input.nextDouble();
        

        if (a == 0) {
            System.out.println("This is not a quadratic equation (a cannot be 0)");
        } else {
            double discriminant = b * b - 4 * a * c;
            
            if (discriminant < 0) {
                System.out.println("Error: No real roots (discriminant is negative)");
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                System.out.println("One real root: " + root);
            } else {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Two real roots:");
                System.out.println("Root 1: " + root1);
                System.out.println("Root 2: " + root2);
            }
        }
        
        input.close();
    }
}