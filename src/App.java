/*public class App {
    public static void main(String[] args) {
        // Savings Account
        SavingsAccount savings = new SavingsAccount("SA001", "Alice", 2000);
        savings.deposit(500);
        savings.withdraw(300);
        savings.printStatement(5);
        System.out.println("Balance: $" + savings.getBalance());

        System.out.println("-------------");

        // Current Account
        CurrentAccount current = new CurrentAccount("CA001", "Bob", 100);
        current.withdraw(900); // should succeed within overdraft
        current.withdraw(300); // should fail
        current.printAllTransactions();
        System.out.println("Balance: $" + current.getBalance());

        System.out.println("-------------");

        // Fixed Deposit Account
        FixedDepositAccount fixed = new FixedDepositAccount("FD001", "Charlie", 5000);
        fixed.withdraw(1000); // should fail (not matured)
        fixed.setMatured(true);
        fixed.withdraw(1000); // should succeed
        fixed.printAllTransactions();
        System.out.println("Balance: $" + fixed.getBalance());
    }
} */
