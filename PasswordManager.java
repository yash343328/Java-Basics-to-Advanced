import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordManager {

    static HashMap<String, String> passwords = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== PASSWORD MANAGER =====");
            System.out.println("1. Add Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Search Password");
            System.out.println("4. Delete Account");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addAccount();
                    break;

                case 2:
                    viewAccounts();
                    break;

                case 3:
                    searchPassword();
                    break;

                case 4:
                    deleteAccount();
                    break;

                case 5:
                    System.out.println("Exiting Password Manager...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addAccount() {
        System.out.print("Enter account name: ");
        String account = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        passwords.put(account, password);

        System.out.println("Account saved successfully!");
    }

    static void viewAccounts() {

        if (passwords.isEmpty()) {
            System.out.println("No accounts saved.");
            return;
        }

        System.out.println("\nSaved Accounts:");
        for (Map.Entry<String, String> entry : passwords.entrySet()) {
            System.out.println("Account: " + entry.getKey() +
                    " | Password: " + entry.getValue());
        }
    }

    static void searchPassword() {
        System.out.print("Enter account name: ");
        String account = sc.nextLine();

        if (passwords.containsKey(account)) {
            System.out.println("Password: " + passwords.get(account));
        } else {
            System.out.println("Account not found.");
        }
    }

    static void deleteAccount() {
        System.out.print("Enter account name to delete: ");
        String account = sc.nextLine();

        if (passwords.remove(account) != null) {
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }
}
