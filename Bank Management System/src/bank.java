import java.util.ArrayList;
public class bank {
    private ArrayList<bank_acc> accounts = new ArrayList();
    public void add_acc(bank_acc account) {
        for(bank_acc acc : this.accounts) {
            if (acc.get_accNumber().equals(account.get_accNumber())) {
                System.out.println("Account number already exists!");
                return;
            }
        }
        this.accounts.add(account);
        System.out.println("Account added successfully for " + account.get_accName());
    }
    public void remove_acc(String accountNumber) {
        bank_acc account = this.get_acc(accountNumber);
        if (account != null) {
            this.accounts.remove(account);
            System.out.println("Account " + accountNumber + " removed successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }
    public bank_acc get_acc(String accountNumber) {
        for(bank_acc acc : this.accounts) {
            if (acc.get_accNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
    public void display_accs() {
        if (this.accounts.isEmpty()) {
            System.out.println("No accounts found in the bank.");
        } else {
            System.out.println("All Bank Accounts:");
            for(bank_acc acc : this.accounts) {
                System.out.println("===============================");
                System.out.println("Account Number: " + acc.get_accNumber());
                System.out.println("Holder Name: " + acc.get_accName());
                System.out.println("Balance: " + acc.ch_balance());
            }
            System.out.println("===============================");
        }
    }
}
