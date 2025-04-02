class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + ". New Balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + ". New Balance: $" + balance);
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    public void displayAccountType() {
        System.out.println("General Bank Account");
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest Applied: $" + interest + ". New Balance: $" + balance);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > withdrawalLimit) {
            System.out.println("Withdrawal exceeds limit of $" + withdrawalLimit);
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
}
class FixedDepositAccount extends BankAccount {
    private int maturityPeriod;

    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    public void displayMaturityDetails() {  
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawals are not allowed before maturity.");
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SAV123", 5000, 4.5);
        CheckingAccount checking = new CheckingAccount("CHK456", 3000, 1000);
        FixedDepositAccount fd = new FixedDepositAccount("FD789", 10000, 12);

        System.out.println("\n--- Savings Account ---");
        savings.displayAccountDetails();
        savings.displayAccountType();
        savings.applyInterest();

        System.out.println("\n--- Checking Account ---");
        checking.displayAccountDetails();
        checking.displayAccountType();
        checking.withdraw(500);
        checking.withdraw(1500);

        System.out.println("\n--- Fixed Deposit Account ---");
        fd.displayAccountDetails();
        fd.displayAccountType();
        fd.displayMaturityDetails(); 
        fd.withdraw(500);
    }
}
