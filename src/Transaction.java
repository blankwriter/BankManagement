import java.time.LocalDateTime;

/**
 * Represents a financial transaction with a type, amount, and timestamp.
 * This class stores transaction details and formats them as a string for display.
 */
public class Transaction {
    
    // Type of the transaction (e.g., Deposit, Withdraw)
    private String type;

    // Amount involved in the transaction
    private double amount;

    // Timestamp indicating when the transaction occurred
    private LocalDateTime timestamp;

    /**
     * Gets the timestamp of the transaction.
     *
     * @return The timestamp of the transaction.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Constructor to initialize a Transaction with a type and amount.
     * The timestamp is automatically set to the current time when the transaction is created.
     *
     * @param type   The type of the transaction (e.g., "Deposit", "Withdraw").
     * @param amount The amount of money involved in the transaction.
     */
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // Set the timestamp to the current date and time
    }

    /**
     * Gets the type of the transaction.
     *
     * @return The type of the transaction (e.g., "Deposit", "Withdraw").
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the amount involved in the transaction.
     *
     * @return The amount of money in the transaction.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns a string representation of the transaction.
     * The format is "timestamp - type: $amount".
     *
     * @return A string describing the transaction details.
     */
    @Override
    public String toString() {
        return timestamp + " - " + type + ": $" + amount;
    }
}
