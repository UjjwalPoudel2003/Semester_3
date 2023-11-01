// Abstract class Insurance
public abstract class Insurance {
    public String type;
    public double monthlyCost;

    // Constructor
    public Insurance(String type) {
        this.type = type;

    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Getter for Monthly cost
    public double getMonthlyCost() {
        return monthlyCost;
    }

    // Setters
    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }
    public abstract void setInsuranceCost(double monthlyFee);

    // Abstract class to display information
    public abstract void displayInfo();
}

