package abstractpack;

public class Demo 
{

	public static void main(String[] args) 
	{
		Stud ss=new Y();
		System.out.println("Name is:"+ss.getName());
		System.out.println(("Roll number is:"+ss.getRoll()));
		ss.display();
	}
	public static void main0(String[] args) 
	{
		Stud ss;
		ss=new X();
		System.out.println("Name is:"+ss.getName());
		System.out.println("Roll number is:"+ss.getRoll());
		
		ss.display();
	}
	/*public static void main(String args[])
	{
		Stud ss=new Stud();//cannot instantiate type Stud 
		
	}*/

}
