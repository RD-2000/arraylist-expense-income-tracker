

import com.arraylist.model.User;
import com.arraylist.model.Wallet;
import com.arraylist.services.TransactionService;
import com.arraylist.services.UserService;
import com.arraylist.services.WalletService;

import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    UserService userService = new UserService();
    WalletService walletService = new WalletService();
    TransactionService transactionService = new TransactionService();
    Scanner scanner = new Scanner(System.in);

    User currentUser = null;

    while (true) {
        System.out.println("\n1. Register");
        System.out.println("2. Login");
        System.out.println("3. Create Wallet");
        System.out.println("4. View Wallets");
        System.out.println("5. Add Transaction");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            userService.registerUser(username, password);
        } else if (choice == 2) {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            currentUser = userService.authenticateUser(username, password);
            if (currentUser == null) {
                System.out.println("Invalid credentials!");
            }
        } else if (choice == 3 && currentUser != null) {
            System.out.print("Enter wallet name: ");
            String name = scanner.next();
            System.out.print("Enter initial balance: ");
            double balance = scanner.nextDouble();
            walletService.createWallet(name, balance);
        } else if (choice == 4 && currentUser != null) {
            for (Wallet wallet : walletService.getAllWallets()) {
                System.out.println(wallet);
            }
        } else if (choice == 5 && currentUser != null) {
            System.out.print("Enter wallet ID: ");
            int walletId = scanner.nextInt();
            Wallet wallet = walletService.getWalletById(walletId);
            if (wallet != null) {
                System.out.print("Enter type (Income/Expense): ");
                String type = scanner.next();
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                System.out.print("Enter category: ");
                String category = scanner.next();
                transactionService.addTransaction(wallet, type, amount, category);
            } else {
                System.out.println("Wallet not found!");
            }
        } else if (choice == 6) {
            break;
        }
    }
}
}