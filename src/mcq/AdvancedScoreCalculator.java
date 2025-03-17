package mcq;

// Extended ScoreCalculator with additional feedback
public class AdvancedScoreCalculator extends ScoreCalculator {
    
    // Initializes AdvancedScoreCalculator with total number of questions
    public AdvancedScoreCalculator(int totalQuestions) {
        super(totalQuestions);
    }

    // Overrides displayScore to add performance feedback
    @Override
    public void displayScore(String userName) {
        super.displayScore(userName); // Calls the base class method to display score

        int percentage = (correctAnswers * 100) / totalQuestions; // Calculate score percentage

        // Provide feedback based on performance
        if (percentage >= 90) {
            System.out.println("Excellent performance!");
        } else if (percentage >= 70) {
            System.out.println("Great job! You're doing well!");
        } else if (percentage >= 50) {
            System.out.println("Good effort! Keep practicing!");
        } else {
            System.out.println("Keep practicing to improve your score.");
        }
    }
}
