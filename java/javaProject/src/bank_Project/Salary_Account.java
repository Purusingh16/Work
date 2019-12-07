package bank_Project;

public class Salary_Account extends Bank_Account
{
	private int transaction=0;
	private static final double transFees;
	
	static
	{
		transFees=10;
	}
	
	public Salary_Account(double balance)
	{
		super(balance);
		this.transaction=0;
	}
	
	@Override
	public void withdrow(double amount) 
	{
		super.withdrow(amount);
		transaction++;
		addfees();
		
	}
	@Override
	public void deposite(double amount) 
	{
		super.deposite(amount);
		transaction++;
		addfees();
	}
	private void addfees()
	{
		if(transaction>3)
		{
			balance=balance-transFees;
			System.out.println("Transaction Fees deducted: "+transFees);
		}
		else 
		{
			System.out.println("no deduction from main balance");
		}
	}
	
}
