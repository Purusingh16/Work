package polymorphism2;

public class Ride 
{
	public static void main(String[] args)
	{
		X1 p1;
		p1=new Y1();
		p1.add(10, 10);
		
	}

	public static void main1(String[] args)
	{
		Y ch=new Y();
		ch.showMessage("child class");
		
		X pr=new X();
		pr.showMessage("parent class");
		
		X pr1=new Y();
		pr1.showMessage("parent class method");
		
	}

}
