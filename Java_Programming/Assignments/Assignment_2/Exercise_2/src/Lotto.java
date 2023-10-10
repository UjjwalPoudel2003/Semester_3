import javax.swing.*;
import java.util.Random;

public class Lotto {
    Random randomNumber = new Random();
    // lotto to hold 3 random integer
    int[] lotto = new int[3];
    int lottoNumber;

    // User entered sum
    int number;

    public Lotto() {
        this.lotto[0] = randomNumber.nextInt(1, 9);
        this.lotto[1] = randomNumber.nextInt(1, 9);
        this.lotto[2] = randomNumber.nextInt(1, 9);
        this.lottoNumber = lotto[0] + lotto[1] + lotto[2];
        this.number = 0;
    }

    // This method returns the lotto array
    public int[] getLotto() {
        return this.lotto;
    }

    // Method to update the lotto in each game
    public void updateLotto() {
        this.lotto[0] += randomNumber.nextInt(1, 9);
        this.lotto[1] += randomNumber.nextInt(1, 9);
        this.lotto[2] += randomNumber.nextInt(1, 9);
        this.lottoNumber = lotto[0] + lotto[1] + lotto[2];
    }

    // This method will simulate the lotto game
    public void playGame() {
        int counter = 0;
        int maxTry = 5;
        while(maxTry > counter) {
            // User Input for the number
            String userNumber = JOptionPane.showInputDialog("Enter the number between 3 and 27 (" + maxTry + " Try Left): ");

            // Checking the integer input error
            try {
                // Converting the number into the integer and adding it
                int number = Integer.parseInt(userNumber);

                if (number> 3 && number < 27) {
                    this.number+= number;

                    // Displaying the user information
                    System.out.println("\n\n|----------------------------------|");
                    System.out.println("Your given number: " + number);
                    System.out.println("Your Total number: " + this.number);
                    System.out.println("Lotto number Was: " + this.lottoNumber);

                    boolean lottoStatus = checkLotto(this.number);
                    if (lottoStatus) {
                        System.out.println("Lotto Status: Lotto Success :) Congratulation");
                        System.out.println("|----------------------------------|");
                        break;
                    } else {
                        updateLotto();
                        maxTry--;

                        // Displaying the user information
                        System.out.println("Lotto Status: Lotto Unmatched");
                        System.out.println("Number of try left: " + maxTry);
                        System.out.println("|----------------------------------|");
                    }
                }

                else {
                    throw new Exception("Please Enter Number between 3 and 27");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Please Provide integer value");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (maxTry < 1) {
            System.out.println("\nYour try is Over, Restart the game :(");
        }
    }

    // This method will check the lotto
    public boolean checkLotto(int number) {
        return number == this.lottoNumber;
    }
}
