import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000.0);

        // Creating a list of transactions
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, 200.0, true));
        transactions.add(new Transaction(account, 150.0, false));
        transactions.add(new Transaction(account, 300.0, true));

        // Creating an ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Executing threads for each transaction
        for (Transaction transaction : transactions) {
            executorService.execute(transaction);
        }

        // Shutting down the executorService
        executorService.shutdown();
    }
}