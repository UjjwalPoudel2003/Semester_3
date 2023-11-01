import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int choice, numberOfHours;
        double result;
        String Name;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the game tester: ");
        Name = scan.nextLine();
        System.out.print("Please choose game tester type\n1-FullTime\n"
                + "2-PartTime" + "\nChoose either 1 or 2: ");
        choice = scan.nextInt();
        if (choice == 1) {

            FullTimeGameTester tester1 = new FullTimeGameTester(Name);
            result = tester1.calculateSalary(0);
            System.out.println("Name: " + tester1.Name());
            System.out.printf("The base salary of full time game tester is :"
                    + "$" + result);
        } else if (choice == 2) {
            PartTimeGameTester tester2 = new PartTimeGameTester(Name);
            System.out.print("Please enter the number of hours: ");
            numberOfHours = scan.nextInt();
            result = tester2.calculateSalary(numberOfHours);
            System.out.println("Name: " + tester2.Name());
            System.out.printf("The salary of part time game tester is :"
                    + "$" + result);
        } else {
            System.out.println("Invalid Option run again");
        }
        scan.close();
    }
}
