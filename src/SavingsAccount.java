public class SavingsAccount extends BankAccount {
    private final double minimumBalance = 500;

    public SavingsAccount(String accNumber, String name, double deposit) {
        super(accNumber, name, deposit);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit", amount);
    }

    @Override
    public void withdraw(double amount){
       if((balance - amount) >= minimumBalance){
        balance -= amount;
        addTransaction("Withdraw", amount);}
        else {
            System.out.println("Minimum balance of 500 required");
        }
    }

    @Override
    public double getBalance() {
        // TODO Auto-generated method stub
        return balance;
    }
}