package stringConcatination;

public class Demo2 
{
	public static void main(String[] args) 
	{
		String s1="ABC";
		byte b[]=s1.getBytes();
		
		int size=b.length;
		for (int i = 0; i < size; i++)
		{
			System.out.println(b[i]+"\t");
		}
		System.out.println("\n");
		char c[]=s1.toCharArray();
		size=c.length;
		for (int i = 0; i < size; i++)
		{
			System.out.println(c[i]+"\t");
		}
		System.out.println("\n");
		
		String ss="This is java program";
		String aa[]=ss.split(" ");
		size=aa.length;
		for (int i = 0; i < size; i++)
		{
			System.out.println(aa[i]);
		}
		String k1=ss.toUpperCase();
		System.out.println(k1);
		String k2=k1.toLowerCase();
		System.out.println(k2);
		
		if (ss.startsWith("This") && (ss.endsWith("program")))
		{
			System.out.println("java Program");
		} else 
		{
			System.out.println("c programing");
		}
	}

}
