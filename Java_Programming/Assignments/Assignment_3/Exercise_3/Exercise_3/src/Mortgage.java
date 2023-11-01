public abstract class Mortgage implements MortgageConstants {
    public int mortgageNumber;
    public String customerName;
    public double amountOfMortgage;
    public double interestRate;
    public double term;

    public Mortgage(int mortgage_Number, String Customer_Name, double amountOfMortgage, double interestRate, double term) throws Exception {
        super();
        if (amountOfMortgage > maxMortgageAmount) {
            throw new Exception("Mortgage Amount cannot be greater than 300,000");
        }
        this.mortgageNumber = mortgage_Number;
        this.customerName = Customer_Name;
        this.interestRate = interestRate;
        this.amountOfMortgage = amountOfMortgage;
        this.term = term;
    }

    public double getTerm() {
        if (term == shortTerm || term == mediumTerm || term == longTerm) {
            return term;
        } else {
            term = shortTerm;
            return term;
        }
    }

    public double calculateTotalAmountOwed() {
        return amountOfMortgage + (amountOfMortgage * interestRate * term);
    }

    public void getMortgageInfo() {
        System.out.println("Mortgage Information for:" + bankName);
        System.out.printf("MortgageNumber: %d", mortgageNumber);
        System.out.printf("\nCustomerName: %s", customerName);
        System.out.printf("\nAmount of Mortgage: %f", amountOfMortgage);
        System.out.printf("\ninterestRate: %f", interestRate);
        System.out.printf("\nterm: %f", getTerm());
        System.out.printf("\nTotal amount owed:%f", calculateTotalAmountOwed());

    }


}
