package bank_projectApp;

public class CheckingAccount extends BankAccount 
{
	private double rate=0.07;
	private int depositCount=0;
	private int depositLimit=6;
	
	public CheckingAccount(double balance,String account_no,String account_holder_name)
	{
		super(balance, account_holder_name, account_holder_name);
	}
	
	@Override
	public void deposite(double amount) 
	{
		depositCount++;
		super.deposite(amount);
	}

	@Override
	public void deductfees()
	{
		if (depositCount>depositLimit) 
		super.balance=super.balance-super.balance*rate;
	}

}
