abstract class BankAccount {
    protected double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    abstract void calculateInterest();

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {

    SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    void calculateInterest() {
        double interest = balance * 0.04;
        balance += interest;
        System.out.println("Savings Interest Added: " + interest);
    }
}

class CurrentAccount extends BankAccount {

    CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    void calculateInterest() {
        System.out.println("No interest for Current Account");
    }
}

public class BankOOPDemo {
    public static void main(String[] args) {

        BankAccount acc1 = new SavingsAccount(10000);
        acc1.deposit(2000);
        acc1.calculateInterest();
        acc1.displayBalance();

        System.out.println();

        BankAccount acc2 = new CurrentAccount(15000);
        acc2.deposit(3000);
        acc2.calculateInterest();
        acc2.displayBalance();
    }
}
