package org.program;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherExample {
    public static void main(String[] args) {
        String[] testSentences = {
            "This is a valid sentence.",
            "this is not valid.",
            "This is not valid",
            "Also Invalid",
            "Correct again."
        };

        Pattern pattern = Pattern.compile("^[A-Z].*\\.$");

        for (String sentence : testSentences) {
            Matcher matcher = pattern.matcher(sentence);
            if (matcher.matches()) {
                System.out.println("\"" + sentence + "\" is valid.");
            } else {
                System.out.println("\"" + sentence + "\" is NOT valid.");
            }
        }
    }
}
