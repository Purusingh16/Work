package demo;

class Out{
	
}
public class In extends Out
{
	public static void main(String[] args)
	{
		In ii=new In();
		System.out.println(ii instanceof In);
		System.out.println(ii instanceof Object);
		
		System.out.println(ii instanceof Out);
		
		String ss=new String("java");
		System.out.println(ss instanceof String);
		System.out.println(ss instanceof Object);
	}

}
