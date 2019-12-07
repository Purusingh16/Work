package class_fundamentals;

public class Demo 
{
	public static void main(String[] args) 
	{
		Demo dd=new Demo();
		dd.i=10;
		call(dd);
		System.out.println(dd.i);
	}
	int i;
	static void call(Demo aa)
	{
		aa.i++;
	}

}
