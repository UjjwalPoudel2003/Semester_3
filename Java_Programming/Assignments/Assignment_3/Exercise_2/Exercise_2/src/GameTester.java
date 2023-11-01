// Abstract class GameTester
public abstract class GameTester {
    // Attributes
    public String gameTesterName;
    public boolean status;

    // Abstract class to calculate salary
    public abstract double calculateSalary(int numberOfHours);

    // Constructor
    public GameTester(String gameTesterName, boolean status) {
        this.gameTesterName = gameTesterName;
        this.status = status;
    }

    // Method to return name
    public String Name() {
        return gameTesterName;
    }
}