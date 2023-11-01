public class BusinessMortgage extends Mortgage {

    public BusinessMortgage(int mortgageNumber, String customerName, double amountOfMortgage, double interestRate,
                            double term) throws Exception {
        super(mortgageNumber, customerName, amountOfMortgage, interestRate, term);
        this.interestRate = 0.1 * interestRate + interestRate;
    }
}
