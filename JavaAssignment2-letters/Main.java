import java.util.HashSet;
import java.util.Set;

public class Main {
    /**
     * Checks if the input string (contains all a-z letters at least once).
     *
     * Time Complexity: O(n), where n = length of the input string
     * Space Complexity: O(1), because at most we store 26 characters (constant)
     */
    public static boolean containsAllLetters(String input) {
        if (input == null) return false;

        Set<Character> seen = new HashSet<>();

        for (char c : input.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                seen.add(c);
                if (seen.size() == 26) return true; 
            }
        }

        return seen.size() == 26;
    }

    public static void main(String[] args) {
        String test1 = "abcDEfghijklmnopqrstuvwxyz";
        String test2 = "Hello World!";

        System.out.println("Is test1 a pangram? " + containsAllLetters(test1)); // true
        System.out.println("Is test2 a pangram? " + containsAllLetters(test2)); // false
    }
}
