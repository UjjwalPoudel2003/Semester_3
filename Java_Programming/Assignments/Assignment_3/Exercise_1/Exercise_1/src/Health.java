// Health class inheriting Insurance
public class Health extends Insurance{
    // Attribute to store monthly fee
    double monthlyFee;

    // Constructor
    public Health(String type) {
        super(type);
    }

    // Setter for insurance cost
    public void setInsuranceCost(double monthlyFee)  {
        setMonthlyCost(monthlyFee);
    }

    // Overwriting the display information
    public void displayInfo() {
        System.out.println("Insurance type:" + getType());
        System.out.println("Insurane monthly Cost:" + getMonthlyCost());
    }
}
