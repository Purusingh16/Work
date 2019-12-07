package bank_projectApp;

public class SavingAccount extends BankAccount 
{
	private double rate=0.05;
	private int withdrowCount=0;
	private int withdrowLimit=5;
	
	public SavingAccount(double balance,String account_no,String account_holder_name )
	{
		super(balance, account_no, account_holder_name);
	}
	 
	@Override
	public void withdrow(double amount)
	{
		withdrowCount++;
		super.withdrow(amount);
	}

	@Override
	public void deductfees() 
	{
		if (withdrowCount>withdrowLimit) 
		super.balance=super.balance-super.balance*rate;
	}

}
