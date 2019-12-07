package bank_projectApp;

public abstract class BankAccount 
{
	double balance;
	String account_no;
	String account_holder_name;
	
	public BankAccount(double balance,String account_no,String account_holder_name)
	{
		this.account_holder_name=account_holder_name;
		this.balance=balance;
		this.account_no=account_no;
	}
	public void withdrow(double amount)
	{
		balance=balance-amount;
	}
	public void deposite(double amount)
	{
		balance=balance+amount;
	}
	public double check_balance() 
	{
		return this.balance;
	}
	public abstract void deductfees();
}
