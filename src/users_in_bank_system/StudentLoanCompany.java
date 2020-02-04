package users_in_bank_system;

import bank_system.CurrentBankAccount;
import bank_system.Transaction;

public class StudentLoanCompany extends Thread{
    private CurrentBankAccount currentBankAccount;
    private String loanCompanyName;

    
    public StudentLoanCompany() {
		super();
	}

	public StudentLoanCompany(CurrentBankAccount currentBankAccount, String loanCompanyName, ThreadGroup threadGroup) {
		super(threadGroup, loanCompanyName);
		this.currentBankAccount = currentBankAccount;
		this.loanCompanyName = loanCompanyName;
	}

	public CurrentBankAccount getCurrentBankAccount() {
		return currentBankAccount;
	}



	public void setCurrentBankAccount(CurrentBankAccount currentBankAccount) {
		this.currentBankAccount = currentBankAccount;
	}



	public String getLoanCompanyName() {
		return loanCompanyName;
	}



	public void setLoanCompanyName(String loanCompanyName) {
		this.loanCompanyName = loanCompanyName;
	}



	@Override
    public void run() {
        System.out.println("\n________________________________Starting Student LoanCompany Transactions________________________________\n");

        for (int i = 0; i < 3; i++) {
            Transaction loan = new Transaction(this.loanCompanyName, 70000);
            currentBankAccount.deposit(loan);
            System.out.println("(LoanCompany) -> Deposit transaction : " + loan);
            try {
                sleep( (int)(Math.random() * 100) ) ;
            }
            catch (InterruptedException e) { 
            	e.printStackTrace();
            }
        }

        System.out.println("\n-----------------------------------Terminating Student LoanCompany Transactions-----------------------------------\n");
    }
}