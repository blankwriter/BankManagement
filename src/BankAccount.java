import java.util.LinkedList;

public abstract class BankAccount implements BankOperations {

  
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected LinkedList<Transaction> transactions = new LinkedList<>();

  public BankAccount (String accNumber, String name, double deposit){
      this.accountHolderName = name;
      this.accountNumber = accNumber;
      this.balance = deposit;
  }

  public void addTransaction(String type, double amount){
    transactions.addFirst(new Transaction(type, amount));
  }

  public void printStatement(int n){
    System.out.println("Last " + n + " transaction:");
    for (int i = 0; i < Math.min(n, transactions.size()); i++) {
        System.out.println(transactions.get(i));
    }
  }
    public void printAllTransactions() {
        transactions.forEach(System.out::println);
    }


    public abstract double getBalance();
}
