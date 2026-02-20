import java.util.Scanner;  

public class Analyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Data data = new Data();
        
        System.out.println("Enter numbers (Q to quit):");
        
        while (true) {  
            System.out.print("Enter number (Q to quit): ");
            String input = scanner.nextLine(); 
        
            input = input.trim();  
            if (input.equalsIgnoreCase("Q")) {  
                break;  
            }
            
            try {
                double value = Double.parseDouble(input);  
                data.addValue(value);  
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number or Q to quit.");
            }
        }
        
        System.out.println("Average = " + data.getAverage());
        System.out.println("Maximum = " + data.getLargest());
        
        scanner.close();  
    }
}