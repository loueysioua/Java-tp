public class Main {
    public static void main(String[] args) {
        BankAccount C = new BankAccount(1234, "John", 1000);
        System.out.println( C.getBalance());
        System.out.println( C.getAccountNumber());
        System.out.println( C.getAccountHolderNumber());

        BankAccount B = new BankAccount();
        B.deposit(1000);
        B.withdraw(100);
        System.out.println( B.getBalance());
        B.withdraw(1100);
    }
}