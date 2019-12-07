
public class Test 
{
	public static void main(String[] args) 
	{
		System.out.println("Hi");
		functionA();
		String name = functionB();
		System.out.println(name);
		
		System.out.println(addStar("Pune"));
		System.out.println(Star("Hello"));
		System.out.println(Concat("Purushottam","Kumar"));
		System.out.println(Add(5,5));
		System.out.println(showInfo("Purushottam",22,25000));
	}
	
	static void functionA()
	{
		System.out.println("Hello");
	}
	static String functionB()
	{
		return "Purushottam";
	}
	static String  addStar(String s)
	{
		return s+"***";
	}
	static String Star(String s)
	{
		return "***"+s+"***";	
	}
	static String Concat(String s1,String s2)
	{
		return s1+" "+s2;
	}
	static int Add(int a,int b)
	{
		return a+b;
	}
	static String showInfo(String name,int age,double salary)
	{
		return "Information:-"+name+" "+age+" "+salary;
	}
}
