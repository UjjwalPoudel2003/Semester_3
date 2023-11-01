import java.util.Scanner;

public class ProcessMortgage {


    public static void main(String[] args) {

        Mortgage[] mortgages = new Mortgage[3];

        double interestRate;
        int mortgageType;
        int mortgageNumber;
        String customerName;
        double amountOfMortgage;
        int term;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the interest rate: ");
        interestRate = scanner.nextDouble();

        for (int i = 0; i < mortgages.length; i++) {
            System.out.println();
            System.out.println("\nEnter the mortgage type:\n1-for Personal\n2- for business");
            mortgageType = scanner.nextInt();
            System.out.print("Enter the mortgage number: ");
            mortgageNumber = scanner.nextInt();
            System.out.print("Enter your name: ");
            customerName = scanner.next();
            System.out.print("Enter the amount of mortgages: ");
            amountOfMortgage = scanner.nextDouble();
            System.out.println("Enter the mortgage term \n1 for short-term \n2 for medium-term\n3 for long-term: ");
            term = scanner.nextInt();

            if (mortgageType == 1) {
                try {
                    mortgages[i] = new PersonalMortgage(mortgageNumber, customerName,
                            amountOfMortgage, interestRate, term);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (mortgageType == 2) {
                try {
                    mortgages[i] = new BusinessMortgage(mortgageNumber, customerName,
                            amountOfMortgage, interestRate, term);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (mortgageType == 3) {
                try {
                    mortgages[i] = new BusinessMortgage(mortgageNumber, customerName,
                            amountOfMortgage, interestRate, term);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            scanner.nextLine();

            for (Mortgage mortgage : mortgages) {
                if (mortgage != null) {
                    mortgage.getMortgageInfo();
                }
            }
        }

        scanner.close();
    }
}



