package mcq;

import java.util.List;
import java.util.Scanner;

// Standard multiple-choice quiz
public class StandardQuiz extends Quiz {

    // Initializes the quiz with questions, user name, and input scanner
    public StandardQuiz(List<Question> questions, String userName, Scanner scanner) {
        super(questions, userName, scanner);
    }

    @Override
    public void start() {
        for (Question q : questions) {
            System.out.println("\n" + q.getText().trim()); // Display the question

            char optionLetter = 'A';
            for (String option : q.getOptions()) {
                System.out.println(optionLetter + ". " + option.trim()); // Display each option
                optionLetter++;
            }

            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim().toUpperCase(); // Read and format user input

            System.out.println(q.formatAnswer(userAnswer)); // Display formatted answer

            if (q.isCorrect(userAnswer)) {
                System.out.println("Correct!\n"); // Correct answer feedback
                scoreCalculator.incrementCorrect(); // Increase score
            } else {
                System.out.println("Wrong! Correct answer: " + q.getFormattedCorrectAnswers() + "\n"); // Show correct answer
            }
        }

        scoreCalculator.displayScore(userName); // Show final score and feedback
    }
}
