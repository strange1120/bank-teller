
public class BankAccount {

	private String accountNum;
	private String type;
	private double balance;
	
	public BankAccount(String accountNum, String type, double balance) {
		this.accountNum = accountNum;
		this.type = type;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
	
	public String getType() {
		return type;
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	@Override 
	public String toString() {
		return "Account Number: " + this.accountNum + "\nType: " + this.type + "\nBalance: " + this.balance;
	}
	
	
}
