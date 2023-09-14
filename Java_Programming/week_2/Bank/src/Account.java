import java.util.HashMap;

public class Account extends Person {
    private String accountType;
    private double balance;

    HashMap <String, HashMap <String, HashMap <Double, Integer>>> accountDetails;

    public void createAccount(String name, int age, String accountType) {
        this.setName(name);
        this.setAge(age);
        this.accountType = accountType;

        if (name != null && accountType.trim().length() != 0 && age != 0) {
            accountDetails = new HashMap<>();
            HashMap <Double, Integer> accountValue = new HashMap<>();
            accountValue.put(0.0, age);

            HashMap <String ,HashMap <Double, Integer>> accountName = new HashMap<>();
            accountName.put(name, accountValue);

            accountDetails.put(accountType, accountName);
        }

        else {
            System.out.println("Fields cannot be empty!");
        }
    }

    public void deposit(double amount) {
        if (amount <= 2500 && amount > 0) {
            this.balance += amount;
            System.out.println("Entered balance: " + amount);
            System.out.println("Updated balance: " + this.balance);
        }
        else {
            System.out.println("You can only deposit between 0 and 2500");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 2500 && amount > 0) {
            this.balance -= amount;
            System.out.println("Withdrawed balance: " + amount);
            System.out.println("Updated balance: " + this.balance);
        }
        else {
            System.out.println("You can only withdraw between 0 and 2500");
        }
    }

    public void displayAllAccountInformation() {
        for (HashMap.Entry<String, HashMap <String, HashMap <Double, Integer>>> outerOuter : accountDetails.entrySet()) {
            String accountType = outerOuter.getKey();
            HashMap <String, HashMap <Double, Integer>> outer = outerOuter.getValue();
            System.out.println("Account Type: " + accountType);

            for (HashMap.Entry<String, HashMap <Double, Integer>> inner : outer.entrySet()) {
                String accountName = inner.getKey();
                HashMap <Double, Integer> innerInner = inner.getValue();
                System.out.println("Account Name: " + accountType);

                for (HashMap.Entry<Double, Integer> finalInner : innerInner.entrySet()) {
                    double accountBalance = finalInner.getKey();
                    int accountAge = finalInner.getValue();

                    System.out.println("Account Balance: " + accountBalance);
                    System.out.println("Account Holder Age: " + accountAge + "\n");
                }
            }
        }
    }
}
