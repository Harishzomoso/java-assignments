
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadingFile {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java CharCounter <input_file_name>");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = "CharacterCounts.txt";
        Map<Character, Integer> charCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char character = (char) ch;
                charCountMap.put(character, charCountMap.getOrDefault(character, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Save the results to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
                writer.write("'" + printableChar(entry.getKey()) + "' : " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Character counts saved to " + outputFileName);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    // Helper to make special characters readable in output
    private static String printableChar(char ch) {
        switch (ch) {
            case '\n': return "\\n";
            case '\r': return "\\r";
            case '\t': return "\\t";
            case ' ': return "space";
            default: return Character.toString(ch);
        }
    }
}

