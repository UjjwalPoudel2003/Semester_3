// Inheriting GameTester Class
public class PartTimeGameTester extends GameTester {

    // Constructor for PartTimeGameTester
    public PartTimeGameTester(String gameTesterName) {
        super(gameTesterName, false);
    }

    // CalculateSalary method for full time or part-time
    public double calculateSalary(int numberOfHours) {
        int hourlyRate = 20;
        double totalSalary = 0;
        if (numberOfHours <= 40) {
            totalSalary = hourlyRate * numberOfHours;
        } else {
            int extraHours = numberOfHours - 40;
            totalSalary = (40 * hourlyRate) + (extraHours * (hourlyRate * 1.5));
        }

        // returns the total salary
        return totalSalary;
    }
}