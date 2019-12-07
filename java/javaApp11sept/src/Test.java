
public class Test 
{
	public static void main(String[] args) 
	{
		int x=100;
		Integer i=new Integer(100);		
		System.out.println(x+" "+i);
		
		char c='a';
		Character ch=new Character('a');
		System.out.println(c+" "+ch);
		
		double d=15.5;
		Double d1=new Double(15.5);
		System.out.println(d+" "+d1);
		
		boolean b=true;
		Boolean b1=new Boolean(false);
		System.out.println(b+" "+b1);
		
		String s="ram";
		String s1=new String("rohan");
	 
		System.out.println(s+" "+s1);
		System.out.println(s.toUpperCase());
		System.out.println(s1.trim());
		
//		int[] marks=new int[5];
		
		int[] marks={20,30,40,50,60,70};
		
		System.out.println("Marks obtained are:");
		for (int j = 0; j < marks.length; j++) 
		{
			System.out.print(marks[j]+" ");
			
		}
		System.out.println("");
		int tot=0;
		for (int j = 0; j < marks.length; j++) 
		{
			tot = tot + marks[j];
		}
		System.out.println("Total=" + tot);
		System.out.println("Avg=" + tot/marks.length);
		
	}
}
