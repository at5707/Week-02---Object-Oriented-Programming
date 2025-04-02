import java.util.*;
abstract class BankAccount{
    private String accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(String accountNumber,String holderName,double balance){
        this.accountNumber=accountNumber;
        this.holderName=holderName;
        this.balance=balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getHolderName(){
        return holderName;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposited: "+amount);
        }else{
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Withdrawn: "+amount);
        }else{
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
    public abstract double calculateInterest();
    public void displayDetails(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Holder Name: "+holderName);
        System.out.println("Balance: "+balance);
        System.out.println("Interest Earned: "+calculateInterest());
    }
}
interface Loanable{
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}
class SavingsAccount extends BankAccount{
    private double interestRate=0.04;
    public SavingsAccount(String accountNumber,String holderName,double balance){
        super(accountNumber, holderName, balance);
    }
    @Override
    public double calculateInterest(){
        return getBalance()*interestRate;
    }
}
class CurrentAccount extends BankAccount implements Loanable{
    private double overdraftLimit=5000;
    public CurrentAccount(String accountNumber,String holderName,double balance){
        super(accountNumber, holderName, balance);
    }
    @Override
    public double calculateInterest(){
        return 0;
    }
    @Override
    public boolean applyForLoan(double amount){
        return amount<=calculateLoanEligibility();
    }
    @Override
    public double calculateLoanEligibility(){
        return getBalance()+overdraftLimit;
    }
}
public class BankingSystem {
    public static void main(String[] args){
        List<BankAccount> accounts=new ArrayList<>();
        accounts.add(new SavingsAccount("SA123", "Alice", 10000));
        accounts.add(new CurrentAccount("CA456", "Bob", 5000));
        for(BankAccount account:accounts){
            account.displayDetails();;
            System.out.println("----------------");
            if(account instanceof Loanable){
                Loanable loanableAccount=(Loanable) account;
                double loanEligibility=loanableAccount.calculateLoanEligibility();
                System.out.println("Loan Eligibility: "+loanEligibility);
            }
            System.out.println();
        }
    }
}
