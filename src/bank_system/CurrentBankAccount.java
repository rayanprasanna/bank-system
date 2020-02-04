package bank_system;

import java.util.concurrent.locks.ReentrantLock;

public class CurrentBankAccount implements BankAccount {
	
	private ReentrantLock reentrantLock;
	private String customerID;
    private String accountNumber;
    private Statement statement;
    private double balance;

    public CurrentBankAccount() {
		super();
	}

	public CurrentBankAccount(String customerID, String accountNumber, double balance, ReentrantLock reentrantLock) {
        this.customerID = customerID;
        this.accountNumber = accountNumber;
        
        this.statement = new Statement();
        
        this.statement.setAccountHolder(customerID);
        this.statement.setAccountNumber(accountNumber);
        
        this.statement = new Statement(this.statement.getAccountHolder(), this.statement.getAccountNumber());
        this.balance = balance;
        
        this.reentrantLock = reentrantLock;
    }

    public ReentrantLock getReentrantLock() {
		return reentrantLock;
	}

	public void setReentrantLock(ReentrantLock reentrantLock) {
		this.reentrantLock = reentrantLock;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	

	@Override
    public synchronized void deposit(Transaction t) {
		double depositAmount = t.getAmount();
		
		this.reentrantLock.lock();
		this.balance += depositAmount;
		this.statement.addTransaction(t.getCID(), depositAmount, this.balance);
		this.reentrantLock.unlock();
        notifyAll();
    }

    @Override
    public synchronized void withdrawal(Transaction t) {
    	this.reentrantLock.lock();
        double withdrawAmount = t.getAmount();

        // validate bank account balance
        while (withdrawAmount > this.balance) {
        	this.reentrantLock.unlock();
            try {
                System.out.println("(CurrentAccount): Withdrawal of " + withdrawAmount + " by " + t.getCID() +
                        " unsuccessful. Waiting until funds are available...");
                wait();
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }finally {
            	this.reentrantLock.lock();
            }
        }

        this.balance -= withdrawAmount;
        this.statement.addTransaction(t.getCID(), withdrawAmount, this.balance);
        this.reentrantLock.unlock();
        notifyAll();
    }

    @Override
    public void printBankStatement() {
        this.statement.print();
    }
     public void printStudentBankStatement() {
    	 this.statement.printStudentBankStatement();
     }
}

