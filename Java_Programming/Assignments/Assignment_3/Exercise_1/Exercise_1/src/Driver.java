import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        // Using try block
        try {
            Insurance[] insurance = new Insurance[4];
            // loop for user input
            for(int i=0; i < insurance.length; i++) {
                double monthlyFee;

                String userChoice;

                Scanner sc= new Scanner(System.in);

                System.out.print("\nPlease enter the type of the insurance and monthly fee\n"
                        + "1-Health \n2-Life");
                System.out.print("\nPlease enter the health insurance type: ");

                userChoice= sc.next().toLowerCase();
                System.out.print("please enter the monthly fee: ");
                monthlyFee= sc.nextDouble();

                if(userChoice.equals("health")) {
                    insurance[i]= new Health(userChoice);
                }
                else if(userChoice.equals("life")) {
                    insurance[i] = new Life(userChoice);
                }
                else {
                    System.out.println("Sorry");
                }

                insurance[i].setInsuranceCost(monthlyFee);
                insurance[i].displayInfo();
            }
        }

        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}