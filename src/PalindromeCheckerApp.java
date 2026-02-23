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
            }
            else {
                System.out.println(original + " is not a palindrome.");
            }
        }
}


