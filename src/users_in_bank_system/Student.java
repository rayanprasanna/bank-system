package users_in_bank_system;

import java.util.ArrayList;
import java.util.Random;
import bank_system.CurrentBankAccount;
import bank_system.Transaction;


public class Student extends Thread{
	
    private CurrentBankAccount currentAccount;
    private String studentName;

    
    public Student() {
		super();
	}

	public Student(CurrentBankAccount account, String name, ThreadGroup group) {
        super(group, name);
        this.currentAccount = account;
        this.studentName = name;
    }

	public CurrentBankAccount getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(CurrentBankAccount currentAccount) {
		this.currentAccount = currentAccount;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private void getRandomTransactions(ArrayList<Transaction> transaction) {
		
        int indexCount  = 0;
        Random rand = new Random();
       
        do {
        	int index = rand.nextInt(6);
        	if (index < 4) {
                currentAccount.withdrawal(transaction.get(index));
                System.out.println("(Student) -> Withdrawal transaction : " + transaction.get(index));                
            } else {
                currentAccount.deposit(transaction.get(index));
                System.out.println("(Student) -> Deposit transaction : " + transaction.get(index));
            }

            try {
                sleep( (int)(Math.random() * 1000) ) ;
            }
            catch (InterruptedException e) { }
            indexCount++;
        }while(indexCount < 6);
    }

    @Override
    public void run() {
        System.out.println("\n________________________________Starting Student Transactions________________________________\n");

        Transaction buySamsungPhone = new Transaction(this.studentName, 45000);
        Transaction onlineOrderFoodByUberEat = new Transaction(this.studentName, 4000);
        Transaction payTelecomBill = new Transaction(this.studentName, 3000);
        Transaction someDonetion = new Transaction(this.studentName, 20000);

        Transaction winLottery = new Transaction(this.studentName, 1000000);
        Transaction sellMyOldPhone = new Transaction(this.studentName, 6000);

        // Randomizing the order in which transactions are performed
        
        ArrayList<Transaction> transactionArrayList = new ArrayList<>();
        
        transactionArrayList.add(buySamsungPhone);
        transactionArrayList.add(onlineOrderFoodByUberEat);
        transactionArrayList.add(payTelecomBill);
        transactionArrayList.add(someDonetion);
        transactionArrayList.add(winLottery);
        transactionArrayList.add(sellMyOldPhone);
        
        getRandomTransactions(transactionArrayList);
        currentAccount.printStudentBankStatement();
        System.out.println("\n-----------------------------------Terminating Student Transactions-----------------------------------");
    }
}
