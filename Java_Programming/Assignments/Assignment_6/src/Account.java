class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit: " + amount + ", Current Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal: " + amount + ", Current Balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}