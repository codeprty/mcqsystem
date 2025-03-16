package mcq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CSVReader {
    /** Reads a CSV file and returns a list of questions. */
    public static List<Question> loadQuestions(String filePath) throws FileNotFoundException {
        List<Question> questions = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath)); // Open the file for reading

        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().replace("\"", "").split(","); // Remove quotes and split by comma
            if (parts.length < 3) continue; // Ensure valid format with at least question, options, and answer

            String questionText = parts[0].trim(); // Extract question text
            List<String> options = new ArrayList<>(Arrays.asList(parts).subList(1, parts.length - 1)); // Extract options
            String correctAnswer = parts[parts.length - 1].trim().toUpperCase(); // Extract and standardize correct answer(s)

            questions.add(new Question(questionText, options, correctAnswer)); // Create and add question object
        }

        scanner.close(); // Close file after reading
        return questions;
    }
}
