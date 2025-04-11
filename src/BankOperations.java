/**
 * This interface defines the basic operations that any bank account class should implement.
 * It includes methods for depositing money, withdrawing money, and retrieving the balance.
 */
public interface BankOperations {

    /**
     * Deposits a specified amount of money into the account.
     *
     * @param amount The amount to deposit into the account.
     */
    void deposit(double amount);

    /**
     * Withdraws a specified amount of money from the account.
     *
     * @param amount The amount to withdraw from the account.
     */
    void withdraw(double amount);

    /**
     * Retrieves the current balance of the account.
     *
     * @return The current balance of the account.
     */
    double getBalance();
}
