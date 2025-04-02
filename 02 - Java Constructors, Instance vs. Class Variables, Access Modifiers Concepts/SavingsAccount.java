class BankAccount{
	public String accountNumber;
	protected String accountHolder;
	private double balance;
	public BankAccount(String accountNumber,String accountHolder,double balance){
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		if(balance>=0){
			this.balance=balance;
		}else{
			System.out.println("Balance cannot be negative.");
		}
	}
	public void displayAccountDetails(){
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Account Holder: "+accountHolder);
		System.out.println("Balance: $"+String.format("%.2f",balance));
	}
}
class SavingsAccount extends BankAccount{
	private double interestRate;
	public SavingsAccount(String accountNumber,String accountHolder,double balance,double interestRate){
		super(accountNumber,accountHolder,balance);
		this.interestRate=interestRate;
	}
	public void displaySavingsAccountDetails(){
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Account Holder: "+accountHolder);
		System.out.println("Interest Rate: "+interestRate+"%");
	}
	public static void main(String[] args){
		BankAccount acc1=new BankAccount("1234567890","Alice Johnson",1500.75);
		acc1.displayAccountDetails();
		acc1.setBalance(2000.50);
		System.out.println("Updated Balance: $"+acc1.getBalance());
		System.out.println();
		SavingsAccount sav1=new SavingsAccount("9876543210","Bob Smith",3000.00,3.5);
		sav1.displaySavingsAccountDetails();
	}
}