package users_in_bank_system;

import bank_system.CurrentBankAccount;
import bank_system.Transaction;

public class University extends Thread{
	
    private CurrentBankAccount currentBankAccount;
    private String universityName;

    public University() {
		super();
	}

	public University(CurrentBankAccount currentBankAccount, String universityName, ThreadGroup threadGroup) {
		super(threadGroup, universityName);
		this.currentBankAccount = currentBankAccount;
		this.universityName = universityName;
	}

	public CurrentBankAccount getCurrentBankAccount() {
		return currentBankAccount;
	}

	public void setCurrentBankAccount(CurrentBankAccount currentBankAccount) {
		this.currentBankAccount = currentBankAccount;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Override
    public void run() {
        System.out.println("\n________________________________Starting University Transactions________________________________\n");

        for (int i = 0; i < 3; i++) {
            Transaction coursePayment = new Transaction(this.universityName, 30000);
            currentBankAccount.withdrawal(coursePayment);
            System.out.println("(University) -> Withdraw transaction : " + coursePayment);
            
            try {
                sleep( (int)(Math.random() * 100) ) ;
            }
            catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }

        System.out.println("\n-----------------------------------Terminating University Transactions-----------------------------------\n");
    }
}
