package stringConcatination;

public class Buffer 
{
	public static void main(String[] args)
	{
		StringBuffer sb1=new StringBuffer("I Java");
		StringBuffer sb2=sb1.insert(2, "Like");
		
		System.out.println(sb1);
		System.out.println(sb2);
		
		StringBuffer sb3=sb1.deleteCharAt(0);
		System.out.println(sb3);
		StringBuffer sb4=sb1.delete(0, 6);
		System.out.println(sb4);
//		
		StringBuffer sb5=sb2.reverse();
		System.out.println(sb5);
//		
		StringBuffer ss=new StringBuffer("This is java program");
		StringBuffer aa=ss.append(sb4);
		System.out.println(aa);
		
	}

}
