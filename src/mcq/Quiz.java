package mcq;

import java.util.List;
import java.util.Scanner;

// Handles the quiz execution, including displaying questions, reading user input, and calculating scores.
public class Quiz {
    private List<Question> questions;
    private Scanner scanner;
    private ScoreCalculator scoreCalculator;
    private String userName;

    // Initializes the quiz with a list of questions, user's name, and scanner for input.
    public Quiz(List<Question> questions, String userName, Scanner scanner) {
        this.questions = questions; // Store the list of questions
        this.userName = userName; // Store the user's name
        this.scanner = scanner; // Store the scanner for user input
        this.scoreCalculator = new ScoreCalculator(questions.size()); // Initialize score calculator with total questions
    }

    // Starts the quiz and processes user responses.
    public void start() {
        for (Question q : questions) {
            System.out.println("\n" + q.getText().trim()); // Display the question text

            char optionLetter = 'A';
            for (String option : q.getOptions()) {
                System.out.println(optionLetter + ". " + option.trim()); // Display each option with a corresponding letter
                optionLetter++;
            }

            // Read user input
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim().toUpperCase(); // Get user input and standardize it

            System.out.println(q.formatAnswer(userAnswer)); // Display formatted user answer

            // Validate answer
            if (q.isCorrect(userAnswer)) {
                System.out.println("Correct!\n"); // Notify user of correct answer
                scoreCalculator.incrementCorrect(); // Increment score
            } else {
                System.out.println("Wrong! Correct answer: " + q.getFormattedCorrectAnswers() + "\n"); // Show correct answer
            }
        }

        scoreCalculator.displayScore(userName); // Display final score after quiz completion
    }
}
