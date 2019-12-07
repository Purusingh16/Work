package reference;

public class Test 
{
	String name;//instance reference
	int roll;//instance variable
	double fee;
	public static void main(String[] args) 
	{
		Test tt;//reference
		tt=new Test();
		tt.name="Amit";
		tt.roll=15;
		tt.fee=456.98;
		System.out.println("name is:"+tt.name+"\nroll is:"+tt.roll+"\nfee is:"+tt.fee);

	}

}
