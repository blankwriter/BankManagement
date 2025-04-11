import java.util.LinkedList;

/**
 * Abstract base class representing a generic bank account.
 * Implements common properties and behaviors shared by all account types.
 */
public abstract class BankAccount implements BankOperations {

    // Account number of the bank account
    protected String accountNumber;

    // Name of the account holder
    protected String accountHolderName;

    // Current balance in the account
    protected double balance;

    // List to store transaction history (most recent at the front)
    protected LinkedList<Transaction> transactions = new LinkedList<>();

    /**
     * Constructor to initialize a BankAccount with an account number,
     * account holder's name, and initial deposit.
     *
     * @param accNumber The account number.
     * @param name      The account holder's name.
     * @param deposit   The initial deposit amount.
     */
    public BankAccount(String accNumber, String name, double deposit) {
        this.accountHolderName = name;
        this.accountNumber = accNumber;
        this.balance = deposit;
    }

    /**
     * Adds a new transaction to the transaction history.
     * The most recent transaction is added to the front of the list.
     *
     * @param type   The type of transaction (e.g., Deposit, Withdraw).
     * @param amount The amount involved in the transaction.
     */
    public void addTransaction(String type, double amount) {
        transactions.addFirst(new Transaction(type, amount));
    }

    /**
     * Prints the last 'n' transactions from the account history.
     *
     * @param n The number of most recent transactions to print.
     */
    public void printStatement(int n) {
        System.out.println("Last " + n + " transaction(s):");
        for (int i = 0; i < Math.min(n, transactions.size()); i++) {
            System.out.println(transactions.get(i));
        }
    }

    /**
     * Prints all transactions associated with this account.
     */
    public void printAllTransactions() {
        transactions.forEach(System.out::println); // Iterates and prints each transaction
    }

    /**
     * Abstract method to get the balance of the account.
     * This method must be implemented by the subclass (e.g., Checking, Savings).
     *
     * @return The current account balance.
     */
    public abstract double getBalance();
}
