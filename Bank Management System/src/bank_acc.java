public class bank_acc {
    private String accNumber;
    private String accName;
    private double balance;
    public bank_acc(String accNumber, String accName, double initial_alance) {
        this.accNumber = accNumber;
        this.accName = accName;
        this.balance = initial_alance;
    }
    public String get_accNumber() {
        return this.accNumber;
    }
    public String get_accName() {
        return this.accName;
    }
    public double ch_balance() {
        return this.balance;
    }
    public void deposit(double amount) {
        if (amount > (double)0.0F) {
            this.balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) {
        if (amount > (double)0.0F) {
            if (this.balance >= amount) {
                this.balance -= amount;
                System.out.println(amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
    public void transfer(bank_acc target, double amount) {
        if (amount > (double)0.0F) {
            if (this.balance >= amount) {
                this.balance -= amount;
                target.balance += amount;
                System.out.println(amount + " transferred to " + target.get_accName());
            } else {
                System.out.println("Insufficient balance for transfer!");
            }
        } else {
            System.out.println("Transfer amount must be positive!");
        }
    }
}
