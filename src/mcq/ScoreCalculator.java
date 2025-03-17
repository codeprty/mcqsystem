package mcq;

// Manages score calculation and displays the final result
public class ScoreCalculator {
    protected int correctAnswers, totalQuestions; // Tracks correct answers and total questions

    // Initializes score calculator with total number of questions
    public ScoreCalculator(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    // Increments the count of correct answers
    public void incrementCorrect() { 
        correctAnswers++; 
    }

    // Displays the user's final score and performance
    public void displayScore(String userName) {
        System.out.println("\n" + userName + ", you got " + correctAnswers + " out of " + totalQuestions + " correct.");
        System.out.println("Your score: " + (correctAnswers * 100 / totalQuestions) + "%");
    }
}
