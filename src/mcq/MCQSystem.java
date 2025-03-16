package mcq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

// Main entry point for the MCQ quiz system.
public class MCQSystem {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine(); // Read user's name

        // Retrieve available quiz files in the "data" folder
        File folder = new File("data/");
        File[] files = folder.listFiles();

        System.out.println("\nAvailable MCQ Sets:");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName().replace(".csv", "")); // Display available quizzes
        }

        // Allow user to select a quiz
        int choice;
        while (true) {
            System.out.print("\nChoose a quiz by number: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline to avoid input issues
                if (choice >= 1 && choice <= files.length) break; // Validate input range
            } else {
                scanner.nextLine(); // Clear invalid input
            }
            System.out.println("Invalid choice, please enter again.");
        }

        // Load selected quiz and start the quiz
        String selectedQuiz = files[choice - 1].getName();
        List<Question> questions = CSVReader.loadQuestions("data/" + selectedQuiz);
        new Quiz(questions, userName, scanner).start(); // Start the quiz

        scanner.close(); // Close scanner to prevent resource leaks
    }
}
