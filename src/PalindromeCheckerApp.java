import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.*;
 class PalindromeBenchmark {
     static boolean twoPointer(String s) {
         String clean2 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
         int left2 = 0, right2 = clean2.length() - 1;

         while (left2 < right2)
             if (clean2.charAt(left2++) != clean2.charAt(right2--))
                 return false;

         return true;
     }

     static boolean stackMethod(String s) {
         String clean3 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
         Stack<Character> stack = new Stack<>();

         for (char c : clean3.toCharArray())
             stack.push(c);

         for (char c : clean3.toCharArray())
             if (c != stack.pop())
                 return false;

         return true;
     }

     static boolean dequeMethod(String s) {
         String clean4 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
         Deque<Character> dq = new ArrayDeque<>();

         for (char c : clean4.toCharArray())
             dq.addLast(c);

         while (dq.size() > 1)
             if (!dq.removeFirst().equals(dq.removeLast()))
                 return false;

         return true;
     }

     static boolean recursiveMethod(String s) {
         String clean5 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
         return rec(clean5, 0, clean5.length() - 1);
     }

     static boolean rec(String s, int l, int r) {
         if (l >= r) return true;
         if (s.charAt(l) != s.charAt(r)) return false;
         return rec(s, l + 1, r - 1);
     }

     static long measure(Runnable algo) {
         long start = System.nanoTime();
         algo.run();
         return System.nanoTime() - start;
     }
 }
class PalindromeCheck {
    private String input1;
    public PalindromeCheck(String input1) {
        this.input1 = input1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
    public boolean checkPalindrome() {
        int left1 = 0;
        int right1 = input1.length() - 1;
        while (left1 < right1) {
            if (input1.charAt(left1) != input1.charAt(right1)) {
                return false;
            }
            left1++;
            right1--;
        }
        return true;
    }
}
interface PalindromeStrategy {
    boolean isPalindrome(String input2);
}
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input2) {
        String cleaned = input2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : cleaned.toCharArray())
            stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty())
            reversed.append(stack.pop());
        return cleaned.equals(reversed.toString());
    }
}
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input2) {
        String clean1 = input2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : clean1.toCharArray())
            deque.addLast(c);

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast()))
                return false;
        }
        return true;
    }
}
class PalindromeChecks {
    private PalindromeStrategy strategy;
    public PalindromeChecks(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean check(String input2) {
        return strategy.isPalindrome(input2);
    }
}
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
        System.out.print("Enter a string to check: ");
        String in = scanner.nextLine();
        String cleanerInput = in.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPally = true;
        if (!cleanerInput.isEmpty()) {
            Deque<Character> charDeque = new ArrayDeque<>();
            for (char ch : cleanerInput.toCharArray()) {
                charDeque.addLast(ch);
            }
            while (charDeque.size() > 1) {
                Character front = charDeque.removeFirst();
                Character rear = charDeque.removeLast();
                if (!front.equals(rear)) {
                    isPally = false;
                    break;
                }
            }
        }
        if (isPally) {
            System.out.println(in + " is a palindrome.");
        } else {
            System.out.println(in + " is not a palindrome.");
        }
         class Node {
            char data;
            Node next;

            Node(char data) {
                this.data = data;
                this.next = null;
            }
        }
        System.out.print("Enter a string to check: ");
        String inps = scanner.nextLine();
        String cleanyInput = inps.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanyInput.isEmpty()) {
            System.out.println("Empty string is considered a palindrome.");
            scanner.close();
            return;
        }
        Node head = null;
        Node tail = null;
        for (char ch : cleanyInput.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node current = slow;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Node secondHalfHead = prev;
        Node firstHalf = head;
        boolean isPals = true;
        Node tempSecond = secondHalfHead;

        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                isPals = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        if (isPals) {
            System.out.println("Result: \"" + inps + "\" is a Palindrome.");
        } else {
            System.out.println("Result: \"" + inps + "\" is not a Palindrome.");
        }
        System.out.print("Enter a string for recursive check: ");
        String recursiveInput = scanner.nextLine();
        String cleanRecInput = recursiveInput.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean[] resultHolder = {true};
        class Recursor {
            void check(int start, int end) {
                if (start >= end) return;
                if (cleanRecInput.charAt(start) != cleanRecInput.charAt(end)) {
                    resultHolder[0] = false;
                    return;
                }
                check(start + 1, end - 1);
            }
        }
        new Recursor().check(0, cleanRecInput.length() - 1);
        if (resultHolder[0]) {
            System.out.println("\"" + recursiveInput + "\" is a palindrome (checked recursively).");
        } else {
            System.out.println("\"" + recursiveInput + "\" is not a palindrome (checked recursively).");
        }
        System.out.print("Enter a string to check: ");
        String inga = scanner.nextLine();
        String normalized = inga.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int lefty = 0;
        int righty = normalized.length() - 1;
        boolean isPalin = true;

        while (lefty < righty) {
            if (normalized.charAt(lefty) != normalized.charAt(righty)) {
                isPalin= false;
                break;
            }
            lefty++;
            righty--;
        }
        if (isPalin) {
            System.out.println("The string is a palindrome!");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        System.out.print("Enter string: ");
        String input1 = scanner.nextLine();
        PalindromeCheck checker = new PalindromeCheck(input1);
        if (checker.checkPalindrome()) {
            System.out.println("It is a palindrome.");
        } else {
            System.out.println("Not a palindrome.");
        }
        System.out.println("=== Dynamic Palindrome Checker ===");
        System.out.println("Choose algorithm:");
        System.out.println("1 → Stack");
        System.out.println("2 → Deque");

        int choice = scanner.nextInt();
        scanner.nextLine();
        PalindromeStrategy strategy;
        switch (choice) {
            case 1:
                strategy = new StackStrategy();
                break;
            case 2:
                strategy = new DequeStrategy();
                break;
            default:
                System.out.println("Invalid choice. Using Stack by default.");
                strategy = new StackStrategy();
        }
        PalindromeChecks checked = new PalindromeChecks(strategy);
        System.out.print("Enter string: ");
        String input2 = scanner.nextLine();
        boolean result = checked.check(input2);
        System.out.println(result ? "Palindrome" : "Not Palindrome");
        System.out.print("Enter string: ");
        String input3 = scanner.nextLine();
        System.out.println("\nRunning benchmarks...\n");
        boolean r1 = PalindromeBenchmark.twoPointer(input3);
        long t1 = PalindromeBenchmark.measure(() -> PalindromeBenchmark.twoPointer(input3));
        boolean r2 = PalindromeBenchmark.stackMethod(input3);
        long t2 = PalindromeBenchmark.measure(() -> PalindromeBenchmark.stackMethod(input3));
        boolean r3 = PalindromeBenchmark.dequeMethod(input3);
        long t3 = PalindromeBenchmark.measure(() -> PalindromeBenchmark.dequeMethod(input3));
        boolean r4 = PalindromeBenchmark.recursiveMethod(input3);
        long t4 = PalindromeBenchmark.measure(() -> PalindromeBenchmark.recursiveMethod(input3));
        System.out.println("\nAlgorithm Results + Performance");
        System.out.println("--------------------------------");
        System.out.println("Two Pointer  : " + r1 + " | " + t1 + " ns");
        System.out.println("Stack        : " + r2 + " | " + t2 + " ns");
        System.out.println("Deque        : " + r3 + " | " + t3 + " ns");
        System.out.println("Recursive    : " + r4 + " | " + t4 + " ns");
        scanner.close();
    }
}




