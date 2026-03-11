import java.util.Scanner;

public class ATMSimulator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int pin = 1234;
        double balance = 10000;
        int enteredPin;

        System.out.print("Enter ATM PIN: ");
        enteredPin = sc.nextInt();

        if (enteredPin != pin) {
            System.out.println("Incorrect PIN. Access Denied.");
            return;
        }

        while (true) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: " + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    balance += deposit;
                    System.out.println("Deposit Successful.");
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();

                    if (withdraw > balance) {
                        System.out.println("Insufficient Balance.");
                    } else {
                        balance -= withdraw;
                        System.out.println("Withdrawal Successful.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using ATM.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Option.");
            }
        }
    }
}
