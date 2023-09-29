import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public class Test {
    // Attribute to store score
    public int score;

    // Array to store questions;
    private final String[] questions = new String[5];

    // Array to store answers
    private final String[] answers = new String[5];

    // Array to store User Answers
    public String[] userAnswers = new String[5];

    // Array to store congratulatory message
    public String[] goodMessages = new String[5];

    // Array to store incorrect message
    public String[] badMessages = new String[5];

    public Test() {
        // Assigning values using constructor
        this.score = 0;
        questions[0] = "What is a keyword used to declare a constant variable in Java?";
        questions[1] = "What keyword is used to declare a class in Java?";
        questions[2] = "Which data type is used to store whole numbers in Java?";
        questions[3] = "What keyword is used to create an instance of a class in Java?";
        questions[4] = "What keyword is used to declare a method that does not return any value in Java?";
        answers[0] = "final";
        answers[1] = "class";
        answers[2] = "int";
        answers[3] = "new";
        answers[4] = "void";
        goodMessages[0] = "Excellent!";
        goodMessages[1] = "Good job!";
        goodMessages[2] = "Keep up the good work!";
        goodMessages[3] = "Nice work!";
        goodMessages[4] = "Well done!";
        badMessages[0] = "Incorrect. Please try again";
        badMessages[1] = "Wrong. Try once more";
        badMessages[2] = "Incorrect but Don't give up!";
        badMessages[3] = "Wrong Answer. Keep trying..";
        badMessages[4] = "That's incorrect";

    }

    // Method to simulate the questions
    public void simulateQuestions(int number) {
        System.out.println("\nQuestion-"+ (number+1) + ": " + this.questions[number]);
    }

    // Method to get the answer
    public String inputAnswer() {
        return JOptionPane.showInputDialog("Enter the answer:");
    }

    // Method to check answer
    public void checkAnswer() {
        // Variable to store incorrect answers
        int wrongAnswers = 0;

        // Using for loop to get the answers
        for(int i = 0; i < 5; i++) {
            // Simulating questions
            simulateQuestions(i);

            // Getting user answers
            String userAnswer = inputAnswer();

            // Checking either answers are correct or incorrect
            if (Objects.equals(userAnswer, this.answers[i])) {
                System.out.println("Your answer: " + userAnswer);
                System.out.println("Correct Answer: " + this.answers[i]);
                System.out.println(generateMessage(true));
                this.score ++;
                System.out.println("Your Score: " + this.score);
            }
            else {
                System.out.println("Your answer: " + userAnswer);
                System.out.println("Correct Answer: " + this.answers[i]);
                System.out.println(generateMessage(false));
                wrongAnswers ++;
                System.out.println("Your Score: " + this.score);
            }
        }

        System.out.println("\nYour correct answers: " + this.score);
        System.out.println("Your wrong answers: " + wrongAnswers);
        System.out.println("Your correct percentage: " + percentCalculator(this.score, 5) + "%");
    }

    // Method to calculate percentage
    public double percentCalculator(int obtained, int total) {
        return ((double) obtained / (double) total) * 100.0;
    }

    // Generate random message
    public String generateMessage(boolean check) {
        Random number = new Random();
        int randomNumber = number.nextInt(5);

        if (check) {
            // Generating random number between 0 and 6
            switch (randomNumber) {
                case 0:
                    return goodMessages[0];
                case 1:
                    return goodMessages[1];
                case 2:
                    return goodMessages[2];
                case 3:
                    return goodMessages[3];
                case 4:
                    return goodMessages[4];
                default:
                    return "Random Number not working";
            }
        }
        else {
            switch (randomNumber) {
                case 0:
                    return badMessages[0];
                case 1:
                    return badMessages[1];
                case 2:
                    return badMessages[2];
                case 3:
                    return badMessages[3];
                case 4:
                    return badMessages[4];
                default:
                    return "Random Number not working";
            }
        }

    }

}
