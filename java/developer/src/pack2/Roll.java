package pack2;

import pack1.Address;

public class Roll extends Address 
{
	 int roll;
	
	 int getRoll(int r)
	{
		 Roll rr=new Roll();
		 System.out.println("Address is:"+rr.getAddress("pune"));
		roll=r;
		return roll;
	}

}
