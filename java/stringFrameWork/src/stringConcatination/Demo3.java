package stringConcatination;

public class Demo3
{
	public static void main(String[] args)
	{
		String s="  java  ";
		String ss=s.trim();
		System.out.println(s.length()+"\t"+ss.length());
		
		String s1="hello";
		String s2="hi";
		String s3="hello";
		String s4="hell";
//		
		System.out.println(s1.compareTo(s2));
		System.out.println(s2.compareTo(s1));
		System.out.println(s1.compareTo(s4));
		System.out.println(s1.compareTo(s3));
//		
		String aa="This is java";
		String sub=aa.substring(0, 7);
		System.out.println(sub);
	}

}
