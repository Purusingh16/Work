package bank_Project;

public class Saving_Account extends Bank_Account 
{
	double interest_Rate=6;
	double interest;
	
	public Saving_Account(double balance,double Interest_Rate)
	{
		super(balance);
		this.interest_Rate=interest_Rate;
//		this.interest=interest;
	}
	public void calculate_Interest(double no_of_month)
	{
		interest=this.interest_Rate/100;
		interest=no_of_month*interest;
		balance=balance+interest;
		System.out.println("total interest a/c month:"+interest);
	}
	@Override
	public String checkBal()
	{
		return super.checkBal();
				
	}
	
}
