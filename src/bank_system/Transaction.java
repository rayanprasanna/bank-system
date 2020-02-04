package bank_system;

public class Transaction {
	
	private final String customerID;
    private final double    amount ;

    public Transaction( String CID, int amount )
    {
        this.customerID = CID ;
        this.amount 	 = amount ;
    }

    public String getCID( )    { return customerID; }

    public double    getAmount( ) { return amount ; }

	
	public String toString() {
		return "[Customer := " + customerID + ", Amount := " + amount + "]";
	}
    
}
