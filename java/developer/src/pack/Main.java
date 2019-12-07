package pack;

import pack1.Name;
import pack2.Address;
import pack3.Roll;

public class Main 
{
	public static void main(String[] args) 
	{
		Name n=new Name();
		Address a=new Address();
		Roll r=new Roll();
		
		System.out.println("Name is:"+n.getName("dipu"));
		System.out.println("Roll no is:"+r.getRoll(101));
		System.out.println("Address is:"+a.getAddress("pune"));
	}

}
