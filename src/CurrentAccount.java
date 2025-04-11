/**
 * Represents a Current Account which allows overdrafts up to a specified limit.
 * Inherits from the BankAccount class and provides implementation for deposit,
 * withdrawal, and balance retrieval, with support for overdraft protection.
 */
public class CurrentAccount extends BankAccount {

    // Overdraft limit for the current account, allowing withdrawals beyond the balance up to this limit
    private final double overDraftLimit = 1000;

    /**
     * Constructor to initialize a CurrentAccount.
     *
     * @param accNumber The account number.
     * @param name      The account holder's name.
     * @param deposit   The initial deposit amount.
     */
    public CurrentAccount(String accNumber, String name, double deposit) {
        super(accNumber, name, deposit); // Calls the parent constructor to initialize common fields
    }

    /**
     * Deposits a specified amount into the current account.
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
     * Withdraws a specified amount from the current account.
     * The withdrawal is allowed if the balance after the withdrawal doesn't exceed the overdraft limit.
     *
     * @param amount The amount to withdraw.
     */
    @Override
    public void withdraw(double amount) {
        // Check if the withdrawal amount does not exceed the overdraft limit.
        // The balance minus the withdrawal amount should not be less than the negative overdraft limit.
        if ((balance - amount) >= -overDraftLimit) {
            balance -= amount; // Deduct the amount from the balance if the withdrawal is allowed.
            addTransaction("Withdraw", amount); // Record the withdrawal transaction in the transaction history.
        } else {
            // If the withdrawal amount exceeds the overdraft limit, throw an exception with an appropriate message.
            throw new IllegalStateException("⚠ Overdraft limit of $1000 exceeded");
        }
    }

    /**
     * Returns the current balance of the current account.
     *
     * @return The current balance.
     */
    @Override
    public double getBalance() {
        return balance; // Return the current account balance
    }
}
