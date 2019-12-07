package bank_Project;

public class Main 
{
	public static void main(String[] args) 
	{
		Salary_Account sa=new Salary_Account(20000);
		System.out.println(sa.checkBal());
		sa.withdrow(1000);
		System.out.println(sa.checkBal());
		sa.deposite(1000);
		System.out.println(sa.checkBal());
		sa.withdrow(1000);
		System.out.println(sa.checkBal());
		sa.withdrow(500);
		System.out.println(sa.checkBal());
		
		Saving_Account saving_Account=new Saving_Account(20000.0,6);
		saving_Account.calculate_Interest(7);
		System.out.println(saving_Account.checkBal());
	}

}
