package bank_Project;

public class Bank_Account 
{
	  double balance;
	 
	 public Bank_Account(double balance)
	 {
		 this.balance=balance;
	 }
	 public void withdrow(double amount)
	 {
		 
		 if(balance>amount)
		 {
			 balance=balance-amount;
		 }
		 else
		 {
			 System.out.println("low balance");
		 }
	}
	 public void deposite(double amount)
	 {
		 balance=balance+amount;
	 }
	 public String  checkBal()
	 {
		 return "tot balance="+this.balance;
	 }
}