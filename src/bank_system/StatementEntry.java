package bank_system;

public class StatementEntry {

    private String CustomerID ;
    private double    amount ;
    private double    currentBalance ;

    
    public StatementEntry() {
		super();
	}


	public StatementEntry( String Coustomer_id, double amount, double currentBal )
    {
        this.CustomerID = Coustomer_id ;
        this.amount     = amount ;
        this.currentBalance = currentBal ;
    }


	public String getCustomerID() {
		return CustomerID;
	}


	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public double getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}


	public String toString() {
		return "StatementEntry [Customer := " + CustomerID + ", Amount := " + amount + ", Current Balance := " + currentBalance
				+ "]";
	}


}
