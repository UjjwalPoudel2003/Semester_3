public class PersonalMortgage extends Mortgage {

    public PersonalMortgage(int mortgageNumber, String customerName, double amountOfMortgage, double interestRate,
                            double term) throws Exception {
        super(mortgageNumber, customerName, amountOfMortgage, interestRate, term);
        this.interestRate = 0.2 * interestRate + interestRate;
    }
}
