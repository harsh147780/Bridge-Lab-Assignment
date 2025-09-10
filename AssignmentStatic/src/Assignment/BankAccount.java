package Assignment;
//import java.util.*;

public class BankAccount {
	
	   // Static variable shared across all accounts
	private static String bankName = "State Bank Of India";
	private static int totalAccount =0;
	
	 // Final variable to ensure account number cannot be changed once assigned
	
	private final String accountNumber;
	private String accountHolderName;
	private double balance;
	
	public BankAccount(String accountHolderName , String accountNumber , double balance) {
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.balance = balance;
		totalAccount++;
		
	}
	
	public static void getTotalAccounts() {
		System.out.println("total no. of accounts " + totalAccount);
		
	}
	public void displayAccountDetails() {
		
		  // Using instanceof to check if the object is a BankAccount instance
		if(this instanceof BankAccount) {
			 System.out.println("Bank Name: " + bankName);
	           System.out.println("Account Holder: " + accountHolderName);
	           System.out.println("Account Number: " + accountNumber);
	           System.out.println("Balance: $" + balance);
	       } else {
	           System.out.println("Invalid account instance.");
	       }
	   }
	
	// getter and setter method
	public String getAccountHolderName(String accountHolderName) {
		return accountHolderName;
	}
	
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	
	public double getBalance(double balance) {
		return balance;
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Deposited: $" + amount);
		}else {
			System.err.println("Invalid deposite amount");
		}
	}
	public void withdraw(double amount) {
		if(amount > 0 && amount <=balance) {
			balance -= amount;
			System.out.println("Withdraw: $" + amount);
		}else {
			System.err.println("Insufficient balance or Invalid Amount");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account1 = new BankAccount("Harsh Chaudhary","SBI1014",1000.0);
		BankAccount account2 = new BankAccount("Raaj Chaudhary" ,"SBI1015",500.0);
		
		System.out.println("Account 1 details:");
		account1.displayAccountDetails();
		
		System.out.print("Account 2 details:");
		account2.displayAccountDetails();
		
		 BankAccount.getTotalAccounts();
	       // Deposit and withdraw operations
	       System.out.println("\nPerforming transactions on Account 1:");
	       account1.deposit(200);
	       account1.withdraw(150);
	       account1.displayAccountDetails();
	       account2.displayAccountDetails();
	       account2.deposit(100);
	       account2.withdraw(800);
	}

}
