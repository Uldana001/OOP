import java.util.Scanner;

public class BankInterest {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter initial balance: $");
        double balance = input.nextDouble();
        
        System.out.print("Enter interest rate (% per year): ");
        double interestRate = input.nextDouble();
        
        System.out.print("Enter number of years: ");
        int years = input.nextInt();
        
        System.out.println("\n=== ACCOUNT GROWTH ===");
        System.out.println("Initial balance: $" + balance);
        System.out.println("Interest rate: " + interestRate + "%");
        
        for (int year = 1; year <= years; year++) {
            double interest = balance * (interestRate / 100);
            balance = balance + interest;
            System.out.printf("Year %d: $%.2f (interest: $%.2f)%n", 
                             year, balance, interest);
        }
        
        System.out.printf("\nFinal balance after %d years: $%.2f%n", 
                         years, balance);
        
        input.close();
    }
}