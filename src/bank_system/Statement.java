package bank_system;

import java.util.ArrayList;

public class Statement {

	public StatementEntry statementEntry;
	private final ArrayList<StatementEntry> bankStatementEntry = new ArrayList<>();

	private String accountHolder ;
	private String accountNumber ;

	private int numOfTransaction = 0 ;

	//implement default constructors
	public Statement() {
		super();
	}

	// implement Parameterized Constructor
	public Statement ( String accountHolder, String accountNumber )
	{
		this.accountHolder = accountHolder ;
		this.accountNumber = accountNumber ;
	}

	public StatementEntry getStatementEntry() {
		return statementEntry;
	}

	public void setStatementEntry(StatementEntry statementEntry) {
		this.statementEntry = statementEntry;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	// implement this addTransaction function for insert Statement Entries into bankStatementEntry ArrayList

	public void addTransaction( String customerID, double amount, double balance )
	{
		this.statementEntry = new StatementEntry();
		
		this.statementEntry.setCustomerID(customerID);
		this.statementEntry.setAmount(amount);
		this.statementEntry.setCurrentBalance(balance);
		
		// Create a new statement entry and add to the statement
		this.statementEntry = new StatementEntry(
				this.statementEntry.getCustomerID(),
				this.statementEntry.getAmount(),
				this.statementEntry.getCurrentBalance());
		
		bankStatementEntry.add(this.statementEntry);

		numOfTransaction++ ;
	}


	public void print ( )
	{
		System.out.println( ) ;

		System.out.println( "Total Statement for " +
				accountHolder + "'s Account: " +
				accountNumber ) ;

		String printFormat = "| %-25s | %-14.02f | %-21.02f |%n";

		System.out.format("+---------------------------+----------------+-----------------------+%n");
		System.out.format("| Customer                  | Amount(Rs)     |    New Balance(Rs)    |%n");
		System.out.format("+---------------------------+----------------+-----------------------+%n");
		for (int i = 0; i < numOfTransaction; i++) {
		    System.out.format(printFormat, bankStatementEntry.get(i).getCustomerID(), bankStatementEntry.get(i).getAmount(), bankStatementEntry.get(i).getCurrentBalance());
		    System.out.format("----------------------------------------------------------------------%n");
		}
		
		System.out.println( ) ;
		
	}
	public void printStudentBankStatement() {
		System.out.println( ) ;

		System.out.println( "Statement for " +
				accountHolder + "'s Account: " +
				accountNumber ) ;

		String printFormat = "| %-25s | %-14.02f | %-21.02f |%n";

		System.out.format("+---------------------------+----------------+-----------------------+%n");
		System.out.format("| Customer                  | Amount(Rs)     |    New Balance(Rs)    |%n");
		System.out.format("+---------------------------+----------------+-----------------------+%n");
		for (int i = 0; i < numOfTransaction; i++) {
		    if(bankStatementEntry.get(i).getCustomerID().equalsIgnoreCase("Rayan")) {
		    	System.out.format(printFormat, bankStatementEntry.get(i).getCustomerID(), bankStatementEntry.get(i).getAmount(), bankStatementEntry.get(i).getCurrentBalance());
			    System.out.format("----------------------------------------------------------------------%n");
		    }
		}
		
		System.out.println( ) ;
	}
}
