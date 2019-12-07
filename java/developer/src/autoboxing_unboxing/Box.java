package autoboxing_unboxing;

public class Box 
{

	public static void main(String[] args) 
	{
		Boolean b1=new Boolean("dipu");
		System.out.println(b1);//false
//variable value directly assign to the subsiquent wrapper class object		
		boolean aa=true;
		b1=aa;//auto-boxing
		System.out.println(b1);//true
		
		System.out.println();
		
		Integer ii1=new Integer(501);
		System.out.println(ii1);
		int i1=502;
		ii1=i1;
		System.out.println(ii1);//502
		
		System.out.println();
		
		System.out.println();
		
		
		Integer ii=new Integer(101);
//wrapper class object directly assign to the variable of subsiquent data type
		int i=ii;//un-boxing
		System.out.println(i);//101
	}

}
