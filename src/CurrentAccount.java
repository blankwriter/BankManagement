public class CurrentAccount extends BankAccount {

    private final double overDraftLimit = 1000;

    public CurrentAccount(String accNumber, String name, double deposit) {
        super(accNumber, name, deposit);
    }

    @Override
    public void deposit(double amount) {
         balance += amount;
         addTransaction("Deposit", amount);
        // TODO Auto-generated method stub
    }

    @Override
    public void withdraw(double amount) {
        if(balance - amount >= -overDraftLimit){
            balance -= amount;
            addTransaction("Withdraw", amount);
        }
        
        else {
            System.out.println("Over draft limit exceeded");
        }
        // TODO Auto-generated method stub
    }

    @Override
    public double getBalance() {
        return balance;
        // TODO Auto-generated method stub
    }
    
}