package mcq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MCQSystem {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in); // Create a Scanner for user input

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine(); // Read user's name

        // Retrieve available quiz files from the "data" folder
        File folder = new File("data/");
        File[] files = folder.listFiles(); // List all quiz files

        System.out.println("\nTopic:");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName().replace(".csv", "")); // Display available quizzes
        }

        int choice;
        while (true) {
            System.out.print("\nChoose a quiz: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice >= 1 && choice <= files.length) break; // Validate input range
            } else {
                scanner.nextLine(); // Clear invalid input
            }
            System.out.println("Invalid choice, please enter again.");
        }

        // Load the selected quiz file
        String selectedQuiz = files[choice - 1].getName();
        List<Question> questions = CSVReader.loadQuestions("data/" + selectedQuiz);

        // Create a StandardQuiz instance and start the quiz
        Quiz quiz = new StandardQuiz(questions, userName, scanner);
        quiz.start();

        scanner.close(); // Close scanner after quiz completion
    }
}
