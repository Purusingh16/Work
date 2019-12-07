package bank_projectApp;

public class Executer 
{
	public static void main(String[] args) 
	{
		BankAccount bankAccount=new SavingAccount(1000, "101", "rahul");
		bankAccount.withdrow(100);
		bankAccount.withdrow(50);
		bankAccount.withdrow(30);
		bankAccount.withdrow(200);
		bankAccount.withdrow(250);
		bankAccount.withdrow(40);
		
		System.out.println("Balance before deduction : " +bankAccount.check_balance());		
		bankAccount.deductfees();
		System.out.println("Balance after deduction : " + bankAccount.check_balance());
		
		BankAccount bankAccount1=new CheckingAccount(1000, "102", "jack");
		bankAccount.deposite(100);
//		bankAccount.deposite(50);
//		bankAccount.deposite(200);
//		bankAccount.deposite(250);
//		bankAccount.deposite(100);
//		bankAccount.deposite(40);
//		bankAccount.deposite(100);
		
		System.out.println("Balance before deduction : " +bankAccount.check_balance());
		bankAccount.deductfees();
		System.out.println("Balance after deduction : " +bankAccount.check_balance());
	}

}
