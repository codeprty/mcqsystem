package mcq;

import java.io.File;
import java.util.*;

public class CSVReader {
	 // Reads a CSV file and returns a list of questions.
    public static List<Question> loadQuestions(String filePath) {
        List<Question> questions = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                // Read and process each line, removing any unnecessary quotes
                String[] parts = scanner.nextLine().replace("\"", "").split(",");

                // Ensure the line has at least a question, options, and an answer
                if (parts.length < 3) continue;

                // Extract question text
                String questionText = parts[0].trim();

                // Extract answer options (excluding the last element, which is the correct answer)
                List<String> options = new ArrayList<>(Arrays.asList(parts).subList(1, parts.length - 1));

                // Extract correct answer(s), converting to uppercase for consistency
                String correctAnswer = parts[parts.length - 1].trim().toUpperCase();

                // Create a Question object and add it to the list
                questions.add(new Question(questionText, options, correctAnswer));
            }
        } catch (Exception e) {
            // Handle errors (e.g., file not found, incorrect format) gracefully
            System.out.println("Error reading file: " + e.getMessage());
        }

        return questions; // Return the list of parsed questions
    }
}
