/**
 * Represents a Savings Account where a minimum balance must be maintained.
 * Inherits from the BankAccount class and provides implementation for deposit, 
 * withdrawal, and balance retrieval.
 */
public class SavingsAccount extends BankAccount {

    // Minimum balance required to maintain the savings account
    private final double minimumBalance = 500;

    /**
     * Constructor to initialize a SavingsAccount.
     *
     * @param accNumber The account number.
     * @param name      The account holder's name.
     * @param deposit   The initial deposit amount.
     */
    public SavingsAccount(String accNumber, String name, double deposit) {
        super(accNumber, name, deposit); // Calls the parent constructor to initialize common fields
    }

    /**
     * Deposits a specified amount into the savings account.
     * Adds the transaction to the transaction history.
     *
     * @param amount The amount to deposit.
     */
    @Override
    public void deposit(double amount) {
        balance += amount; // Increase balance by the deposit amount
        addTransaction("Deposit", amount); // Record the deposit transaction
    }

    /**
     * Withdraws a specified amount from the savings account.
     * The withdrawal is allowed only if the balance remains above the minimum balance.
     *
     * @param amount The amount to withdraw.
     */
    @Override
    public void withdraw(double amount) {
        // Check if the withdrawal will keep the balance above the minimum balance
        if ((balance - amount) >= minimumBalance) {
            balance -= amount; // Deduct the amount from the balance
            addTransaction("Withdraw", amount); // Record the withdrawal transaction
        } else {
            System.out.println("Minimum balance of 500 required"); // Warn the user if minimum balance is violated
        }
    }

    /**
     * Returns the current balance of the savings account.
     *
     * @return The current balance.
     */
    @Override
    public double getBalance() {
        return balance; // Return the current account balance
    }
}
