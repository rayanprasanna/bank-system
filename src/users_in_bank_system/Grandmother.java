package users_in_bank_system;

import bank_system.CurrentBankAccount;
import bank_system.Transaction;

public class Grandmother extends Thread{
	
    private CurrentBankAccount currentBankAccount;
    private String grandmotherName;

 
    public Grandmother() {
		super();
	}


	public Grandmother(CurrentBankAccount currentBankAccount, String grandmotherName, ThreadGroup threadGroup) {
		super(threadGroup, grandmotherName);
		this.currentBankAccount = currentBankAccount;
		this.grandmotherName = grandmotherName;
	}

	public CurrentBankAccount getCurrentBankAccount() {
		return currentBankAccount;
	}


	public void setCurrentBankAccount(CurrentBankAccount currentBankAccount) {
		this.currentBankAccount = currentBankAccount;
	}


	public String getGrandmotherName() {
		return grandmotherName;
	}


	public void setGrandmotherName(String grandmotherName) {
		this.grandmotherName = grandmotherName;
	}


	@Override
    public void run() {
        System.out.println("\n________________________________Starting Grandmother Transactions________________________________\n");

        Transaction birthday_gift = new Transaction(this.grandmotherName, 50000);
        currentBankAccount.deposit(birthday_gift);
        System.out.println("(Grandmother) -> Deposit transaction : " + birthday_gift);
        
        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        Transaction new_year_gift = new Transaction(this.grandmotherName, 50000);
        currentBankAccount.deposit(new_year_gift);
        System.out.println("(Grandmother) -> Deposit transaction : " + new_year_gift);
        

        System.out.println("\n-----------------------------------Terninating Grandmother Transactions-----------------------------------\n");

    }
}