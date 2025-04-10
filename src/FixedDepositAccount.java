public class FixedDepositAccount extends BankAccount {
    private boolean matured = false;

    public void setMatured(boolean matured) {
        this.matured = matured;
    }



    public FixedDepositAccount(String accNumber, String name, double deposit) {
        super(accNumber, name, deposit);
        //TODO Auto-generated constructor stub
    }

    

    @Override
    public void deposit(double amount) {
        System.out.println("Cannot deposit after fixed deposit is created"); }
        // TODO Auto-generated method stub
    

    @Override
    public void withdraw(double amount) {
        if (matured) {
            balance -= amount;
            addTransaction("Withdraw", amount);
        }

        else {
            System.out.println("Withdrawal denied. Account not matured");
        }
        // TODO Auto-generated method stub
    }

    @Override
    public double getBalance() {
        return balance;
        // TODO Auto-generated method stub
    }

    
}