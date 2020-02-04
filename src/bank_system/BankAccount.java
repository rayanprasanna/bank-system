package bank_system;

public interface BankAccount {
	

    void deposit(Transaction t) ;     // deposit transaction on the bank account

    void withdrawal(Transaction t) ;  // withdrawal transaction on the bank account

    void printBankStatement() ;         // prints out the Bank Statement
    
	 
}
