public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private int balance;

    public BankAccount() {
    }

    public BankAccount(int accountNumber, String accountHolderName, int balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public int getAccountNumber() {
        return (this.accountNumber);
    }

    public String getAccountHolderNumber() {
        return (this.accountHolderName);
    }

    public int getBalance() {
        return (this.balance);
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (this.balance >= amount)
            this.balance -= amount;
        else
            System.out.println("cannot withdraw");
    }

}
