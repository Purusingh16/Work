package polymorphism;
class Bike
{
	void run()
	{
		System.out.println("Running");
	}
}
public class Splender extends Bike
{
	@Override
	void run() 
	{
//		super.run();
		System.out.println("running safely with 60km");
	}
	public static void main(String args[])
	{
	Bike b=new Splender();
	b.run();
	}

}
