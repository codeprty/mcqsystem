package mcq;

import java.util.List;
import java.util.Scanner;

// Base class for different quiz types
public abstract class Quiz {
    protected List<Question> questions; // Stores the list of quiz questions
    protected Scanner scanner; // Handles user input
    protected ScoreCalculator scoreCalculator; // Manages score calculation
    protected String userName; // Stores the user's name

    // Initializes the quiz with questions, user's name, and input scanner
    public Quiz(List<Question> questions, String userName, Scanner scanner) {
        this.questions = questions;
        this.userName = userName;
        this.scanner = scanner;
        this.scoreCalculator = new AdvancedScoreCalculator(questions.size()); // Uses advanced scoring with feedback
    }

    // Starts the quiz (implemented by subclasses)
    public abstract void start();
}
