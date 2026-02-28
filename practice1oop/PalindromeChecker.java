import java.util.Scanner;

public class PalindromeChecker {
    
    public static boolean isPalindrome(String text) {
        text = text.replace(" ", "").toLowerCase();
        
        int left = 0;
        int right = text.length() - 1;
        
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;  
            }
            left++;
            right--;
        }
        
        return true;  
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a word or phrase: ");
        String text = input.nextLine();
        
        if (isPalindrome(text)) {
            System.out.println("\"" + text + "\" is a palindrome!");
        } else {
            System.out.println("\"" + text + "\" is NOT a palindrome.");
        }
        
    }
}