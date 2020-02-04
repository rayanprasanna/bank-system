package users_in_bank_system;


import java.util.concurrent.locks.ReentrantLock;

import bank_system.CurrentBankAccount;

public class BankingSystem {
	
	ReentrantLock reentrantLock;
	Student student;
    Grandmother grany;
    StudentLoanCompany company;
    University university;

    CurrentBankAccount studentBankAccount;

    ThreadGroup humans;
    ThreadGroup serviceStation;

    public BankingSystem() {
    	this.reentrantLock = new ReentrantLock();
        this.humans = new ThreadGroup("Humans");
        this.serviceStation = new ThreadGroup("ServiceStation");

        this.studentBankAccount = new CurrentBankAccount();// create new Current Bank Account
        
        this.studentBankAccount.setCustomerID("Rayan");
        this.studentBankAccount.setAccountNumber("2016354ID");
        this.studentBankAccount.setBalance(0);
        this.studentBankAccount.setReentrantLock(reentrantLock);
        
        this.studentBankAccount = new CurrentBankAccount(
        		this.studentBankAccount.getCustomerID(),
        		this.studentBankAccount.getAccountNumber(),
        		this.studentBankAccount.getBalance(),
        		this.studentBankAccount.getReentrantLock());
        
        this.student = new Student();// create new Student Object
        
        this.student.setCurrentAccount(studentBankAccount);
        this.student.setStudentName(studentBankAccount.getCustomerID());
        
        this.student = new Student(
        		this.student.getCurrentAccount(),
        		student.getStudentName(),
        		humans);
        
        this.grany = new Grandmother();//create new grandmother Object
        
        this.grany.setCurrentBankAccount(studentBankAccount);
        this.grany.setGrandmotherName("Rayan's grandmom");
        
        this.grany = new Grandmother(
        		this.grany.getCurrentBankAccount(),
        		this.grany.getGrandmotherName(),
        		humans);

        this.company = new StudentLoanCompany();// create new StudentLoanCompany Object
        
        this.company.setCurrentBankAccount(studentBankAccount);
        this.company.setLoanCompanyName("Student Loan");
        
        this.company = new StudentLoanCompany(
        		this.company.getCurrentBankAccount(),
        		this.company.getLoanCompanyName(),
        		serviceStation);
        
        this.university = new University();// create new University Object
        
        this.university.setCurrentBankAccount(studentBankAccount);
        this.university.setUniversityName("IIT");
        
        this.university = new University(
        		this.university.getCurrentBankAccount(),
        		this.university.getUniversityName(),
        		serviceStation);
    }

    public static void main (String[] args) {
        BankingSystem bankingSystem = new BankingSystem();

        bankingSystem.student.start();
        bankingSystem.grany.start();
        bankingSystem.company.start();
        bankingSystem.university.start();

        try {
            bankingSystem.student.join();
            bankingSystem.grany.join();
            bankingSystem.company.join();
            bankingSystem.university.join();
        } catch (InterruptedException e) { }

        // print out final bank statement
        bankingSystem.studentBankAccount.printBankStatement();
    }
}

