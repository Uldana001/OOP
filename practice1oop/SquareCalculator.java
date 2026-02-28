import java.util.Scanner;

public class SquareCalculator {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the side length of square: ");
        double side = input.nextDouble();
        
        double area = side * side;
        double perimeter = 4 * side;
        double diagonal = side * Math.sqrt(2);
        
        System.out.println("\n=== SQUARE RESULTS ===");
        System.out.println("Side length: " + side);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Diagonal: " + diagonal);
        
        input.close();
    }
}
