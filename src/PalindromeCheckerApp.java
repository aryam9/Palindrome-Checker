import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String appName = "Palindrome Checker Pro";
        String version = "1.0.0";

        System.out.println("========================================");
        System.out.println("Welcome to " + appName);
        System.out.println("Version: " + version);
        System.out.println("========================================");

        System.out.println("System initialized. Ready for input...");
        String original = "madam";
        String reversed = "";
        int length = original.length();
        for (int i = length - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }
        if (original.equals(reversed)) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String useroriginal = scanner.nextLine();
        String userreversed = "";
        for (int i = useroriginal.length() - 1; i >= 0; i--) {
            userreversed += useroriginal.charAt(i);
        }
        if (useroriginal.equalsIgnoreCase(userreversed)) {
            System.out.println("Result: '" + useroriginal + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + useroriginal + "' is not a palindrome.");
        }
        String input = "radar";
        if (input == null || input.isEmpty()) {
            System.out.println("Empty string.");
        } else {
            char[] charArray = input.toCharArray();
            int start = 0;
            int end = charArray.length - 1;
            boolean isPalindrome = true;

            while (start < end) {
                if (charArray[start] != charArray[end]) {
                    isPalindrome = false;
                    break;
                }
                start++;
                end--;
            }

            if (isPalindrome) {
                System.out.println("Result : '" + input + "' is a Palindrome.");
            } else {
                System.out.println("Result : '" + input + "' is not a Palindrome.");
            }
        }
        Stack<Character> stack = new Stack<>();
        System.out.print("Enter a string: ");
        String inp = scanner.nextLine();
        String cleanedInput = inp.replaceAll("\\s+", "").toLowerCase();
        for (int i = 0; i < cleanedInput.length(); i++) {
            stack.push(cleanedInput.charAt(i));
        }
        StringBuilder reversedInput = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedInput.append(stack.pop());
        }
        if (cleanedInput.equals(reversedInput.toString())) {
            System.out.println("\"" + inp + "\" is a palindrome.");
        } else {
            System.out.println("\"" + inp + "\" is not a palindrome.");
        }
        boolean ispal = true;
        System.out.print("Enter a string: ");
        String inputter = scanner.nextLine();
        String cleanInput = inputter.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();
        for (char ch : cleanInput.toCharArray()) {
            queue.add(ch);
            stack2.push(ch);
        }
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack2.pop())) {
                ispal = false;
                break;
            }
        }
        if (ispal) {
            System.out.println(inputter + " is a palindrome.");
        }
        else {
            System.out.println(inputter + " is not a palindrome.");
        }
        scanner.close();
    }
}







