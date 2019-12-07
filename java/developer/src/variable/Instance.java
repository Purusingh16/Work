package variable;

public class Instance 
{
	String name;
	int roll;
	void show(String n,int r)
	{
		name=n;
		roll=r;
	}
	public static void main(String[] args) 
	{
		Instance instance=new Instance();
		instance.show("dipu", 101);
		System.out.println("name is:"+instance.name+"\nroll number is:"+instance.roll);
	}

}
