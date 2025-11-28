import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        bank b = new bank();
        while (true) {
            System.out.println("\n===== BANK SYSTEM MENU =====");
            System.out.println("1. Add Account");
            System.out.println("2. Remove Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer Money");
            System.out.println("6. Display One Account");
            System.out.println("7. Display All Accounts");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine(); // consume new line
            switch (choice) {
                case 1: // Add Account
                    System.out.print("Enter Account Number: ");
                    String accNum = input.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accName = input.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = input.nextDouble();
                    b.add_acc(new bank_acc(accNum, accName, balance));
                    break;
                case 2: // Remove Account
                    System.out.print("Enter Account Number to Remove: ");
                    String removeNum = input.nextLine();
                    b.remove_acc(removeNum);
                    break;
                case 3: // Deposit
                    System.out.print("Enter Account Number: ");
                    String depAcc = input.nextLine();
                    bank_acc dep = b.get_acc(depAcc);
                    if (dep != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double depAmount = input.nextDouble();
                        dep.deposit(depAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 4: // Withdraw
                    System.out.print("Enter Account Number: ");
                    String wAcc = input.nextLine();
                    bank_acc w = b.get_acc(wAcc);
                    if (w != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double wAmount = input.nextDouble();
                        w.withdraw(wAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 5: // Transfer
                    System.out.print("Enter Sender Account Number: ");
                    String sAcc = input.nextLine();
                    bank_acc sender = b.get_acc(sAcc);
                    System.out.print("Enter Receiver Account Number: ");
                    String rAcc = input.nextLine();
                    bank_acc receiver = b.get_acc(rAcc);
                    if (sender != null && receiver != null) {
                        System.out.print("Enter Amount to Transfer: ");
                        double tAmount = input.nextDouble();
                        sender.transfer(receiver, tAmount);
                    } else {
                        System.out.println("One or both accounts not found!");
                    }
                    break;
                case 6: // Display one account
                    System.out.print("Enter Account Number: ");
                    String dAcc = input.nextLine();
                    bank_acc acc = b.get_acc(dAcc);
                    if (acc != null) {
                        System.out.println("\n===== Account Details =====");
                        System.out.println("Account Number: " + acc.get_accNumber());
                        System.out.println("Holder Name: " + acc.get_accName());
                        System.out.println("Balance: " + acc.ch_balance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 7: // Display all accounts
                    b.display_accs();
                    break;
                case 8: // Exit
                    System.out.println("Exiting system... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
