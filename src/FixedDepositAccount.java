/**
 * Represents a Fixed Deposit Account where no deposits can be made after the account is created
 * and withdrawals are only allowed after the account has matured.
 * Inherits from the BankAccount class and overrides the deposit, withdraw, and balance retrieval behaviors.
 */
public class FixedDepositAccount extends BankAccount {

    // Flag to indicate whether the fixed deposit account has matured
    private boolean matured = false;

    /**
     * Sets the matured status of the Fixed Deposit Account.
     *
     * @param matured The status to set (true if matured, false if not).
     */
    public void setMatured(boolean matured) {
        this.matured = matured; // Update the matured status of the account
    }

    /**
     * Constructor to initialize a FixedDepositAccount.
     *
     * @param accNumber The account number.
     * @param name      The account holder's name.
     * @param deposit   The initial deposit amount.
     */
    public FixedDepositAccount(String accNumber, String name, double deposit) {
        super(accNumber, name, deposit); // Calls the parent constructor to initialize common fields
    }

    /**
     * Deposits a specified amount into the account. 
     * This operation is not allowed for Fixed Deposit Accounts after they are created.
     *
     * @param amount The amount to deposit (which is ignored).
     */
    @Override
    public void deposit(double amount) {
        // No deposits allowed after the fixed deposit is created
        System.out.println("Cannot deposit after fixed deposit is created");
    }

    /**
     * Withdraws a specified amount from the account, but only if the account has matured.
     *
     * @param amount The amount to withdraw.
     */
    @Override
    public void withdraw(double amount) {
        // Check if the account has matured
        if (matured) {
            balance -= amount; // Deduct the amount from the balance
            addTransaction("Withdraw", amount); // Record the withdrawal transaction
        } else {
            System.out.println("Withdrawal denied. Account not matured"); // Deny withdrawal if account is not matured
        }
    }

    /**
     * Returns the current balance of the Fixed Deposit Account.
     *
     * @return The current balance of the account.
     */
    @Override
    public double getBalance() {
        return balance; // Return the current balance of the account
    }
}
