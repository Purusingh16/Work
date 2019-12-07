package objectClass;

public class Demo 
{
	int i;
	public static void main(String[] args) 
	{
		Demo dd=new Demo();
		dd.i=10;
		
		Demo aa=new Demo();
		aa.i++;
		
		System.out.println(aa.hashCode()+"\t"+dd.hashCode());
		
		if(aa.equals(dd))
		{
			System.out.println("Equals");
		}else
		{
			System.out.println("Not Equals");
		}
		aa=dd;
		System.out.println(aa.hashCode()+"\t"+aa.hashCode());
		if(aa.equals(dd))
		{
			System.out.println("Equals");
		}else
		{
			System.out.println("Not Equals");
		}
	}

}
