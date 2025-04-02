class BankAccount{
	public static String bankName="Global Bank";
	private static int totalAccounts=0;
	private final String accountNumber;
	private String accountHolderName;
	private double balance;
	public BankAccount(String accountHolderName,String accountNumber,double initialBalance){
		this.accountHolderName=accountHolderName;
		this.accountNumber=accountNumber;
		this.balance=initialBalance;
		totalAccounts++;
	}
	public static void getTotalAccounts(){
		System.out.println("Total accounts: "+totalAccounts);
	}
	public void displayAccountDetails(){
		if(this instanceof BankAccount){
			System.out.println("Bank Name: "+bankName);
			System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
		}else{
			System.out.println("Invalid");
		}
	}
	public static void main(String[] args){
		BankAccount acc1=new BankAccount("John Doe","1234567890",5000.0);
		BankAccount acc2=new BankAccount("Jane Smith","0987654321",10000.0);
		acc1.displayAccountDetails();
		System.out.println();
		acc2.displayAccountDetails();
		BankAccount.getTotalAccounts();
	}
}