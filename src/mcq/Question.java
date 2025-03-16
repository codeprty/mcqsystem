package mcq;

import java.util.List;
import java.util.Arrays;

// Represents a multiple-choice question with multiple possible correct answers.
public class Question {
    private String text;
    private List<String> options;
    private List<String> correctAnswers;

    // Constructs a question with text, options, and one or more correct answers.
    public Question(String text, List<String> options, String correctAnswers) {
        this.text = text.trim(); // Remove leading/trailing spaces from the question text
        this.options = options.stream().map(String::trim).toList(); // Trim spaces from each option
        this.correctAnswers = Arrays.asList(correctAnswers.trim().toUpperCase().split(";")); // Convert answers to uppercase for case-insensitive check
    }

    // Returns the question text.
    public String getText() { return text; }

    // Returns the list of answer options.
    public List<String> getOptions() { return options; }

    // Returns the list of correct answer choices.
    public List<String> getCorrectAnswers() { return correctAnswers; }

    // Checks if the user's answer is correct.
    public boolean isCorrect(String userAnswer) {
        return correctAnswers.contains(userAnswer.trim().toUpperCase()); // Compare after trimming and converting to uppercase
    }

    // Formats the user's answer choice for display.
    public String formatAnswer(String answer) {
        return answer.trim() + ". " + getOptionText(answer);
    }

    // Retrieves the formatted correct answers for display.
    public String getFormattedCorrectAnswers() {
        StringBuilder correctText = new StringBuilder();
        for (String answer : correctAnswers) {
            correctText.append(answer).append(". ").append(getOptionText(answer)).append(" ");
        }
        return correctText.toString().trim(); // Remove any trailing spaces
    }

    // Retrieves the answer option text based on a given letter choice.
    public String getOptionText(String answer) {
        int index = answer.charAt(0) - 'A'; // Convert letter choice to an index (e.g., 'A' -> 0)
        return (index >= 0 && index < options.size()) ? options.get(index).trim() : "Invalid option selected."; // Validate index range
    }
}
