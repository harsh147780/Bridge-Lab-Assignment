package StudentManagementSystem;
import java.util.*;

interface TransactionLogger {
    void logTransaction(Transaction transaction);
}

class Transaction {
    private String transactionId;
    private Date date;
    private double amount;
    private String type;

    public Transaction(String transactionId, double amount, String type) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.date = new Date();
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }
    public Date getDate() {
        return date;
    }
    public double getAmount() {
        return amount;
    }
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return transactionId +" " + type + "  " + amount + "  " + date;
    }
}

// Abstract ATM class (Abstraction)
abstract class ATM {
    protected String location;
    protected String machineId;

    public ATM(String location, String machineId) {
        this.location = location;
        this.machineId = machineId;
    }

    public abstract void withdraw(Account account, double amount);
    public abstract void deposit(Account account, double amount);
}

// Account class (Base class)
class Account {
    private String accountNumber;
    private String holderName;
    protected double balance;
    protected List<Transaction> transactions;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public double getBalance() {
        return balance;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }
}

// SavingsAccount (Inheritance + Method Overriding)
class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 500.0;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public boolean canWithdraw(double amount) {
        return (balance - amount) >= MIN_BALANCE;
    }
}

// CurrentAccount (Inheritance)
class CurrentAccount extends Account {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // Current account can go into overdraft (for demo, allow negative balance up to -1000)
    public boolean canWithdraw(double amount) {
        return (balance - amount) >= -1000;
    }
}

// Concrete ATM class implementing TransactionLogger
class BankATM extends ATM implements TransactionLogger {
    public BankATM(String location, String machineId) {
        super(location, machineId);
    }

    @Override
    public void withdraw(Account account, double amount) {
        boolean allowed = false;

        if (account instanceof SavingsAccount) {
            allowed = ((SavingsAccount) account).canWithdraw(amount);
        } else if (account instanceof CurrentAccount) {
            allowed = ((CurrentAccount) account).canWithdraw(amount);
        }

        if (allowed) {
            account.balance -= amount;
            Transaction t = new Transaction(UUID.randomUUID().toString(), amount, "Withdraw");
            account.addTransaction(t);
            logTransaction(t);
            System.out.println("Withdraw successful: " + amount);
        } else {
            System.out.println("Withdrawal denied: Insufficient balance.");
        }
    }

    @Override
    public void deposit(Account account, double amount) {
        account.balance += amount;
        Transaction t = new Transaction(UUID.randomUUID().toString(), amount, "Deposit");
        account.addTransaction(t);
        logTransaction(t);
        System.out.println("Deposit successful: " + amount);
    }

    @Override
    public void logTransaction(Transaction transaction) {
        System.out.println("Logged Transaction → " + transaction);
    }
}

// Main Class
public class AtmSystem {
    public static void main(String[] args) {
        BankATM atm = new BankATM("Downtown", "ATM001");

        Account s1 = new SavingsAccount("SA001", "Harsh Chaudhary", 2000);
        Account c1 = new CurrentAccount("CA001", "Raaj Chaudhary", 1000);

        // Transactions
        atm.withdraw(s1, 1700);   // Leaves only 300 → should fail (below min balance)
        atm.withdraw(s1, 1000);   // Leaves 1000 → works
        atm.deposit(c1, 500);
        atm.withdraw(c1, 2000);   // Works (CurrentAccount overdraft allowed up to -1000)

        // Print account statements
        System.out.println("\n--- Savings Account Transactions ---");
        for (Transaction t : s1.getTransactions()) {
            System.out.println(t);
        }
        System.out.println("Final Balance: " + s1.getBalance());

        System.out.println("\n--- Current Account Transactions ---");
        for (Transaction t : c1.getTransactions()) {
            System.out.println(t);
        }
        System.out.println("Final Balance: " + c1.getBalance());
    }
}
