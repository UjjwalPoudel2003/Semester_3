// Inheriting the Insurance class
public class Life extends Insurance {
    // Attribute to store monthly fee
    double monthlyFee;

    // Constructor for life
    public Life(String type) {
        super(type);
    }

    // Set Insurance method
    public void setInsuranceCost(double monthlyFee)  {
        setMonthlyCost(monthlyFee);
    }

    // Overwriting the display info method
    public void displayInfo() {
        System.out.println("Insurance Type:" + getType());
        System.out.println("Insurance Monthly Cost:" +  getMonthlyCost());
    }
}