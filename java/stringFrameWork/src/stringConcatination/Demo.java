package stringConcatination;

public class Demo
{

	public static void main(String[] args)
	{
		String s="This is a demo of java program";
		int index=s.indexOf('a');
		System.out.println("First a is present in:"+index);
		
		index=s.indexOf('a', 17);
		System.out.println("Next a is available in:"+index);
		
		index=s.lastIndexOf('a');
		System.out.println("Last a is available in:"+index);
		
		int size=s.length();
		System.out.println("Length of the string is:"+size);
		
		char ch=s.charAt(s.indexOf('j'));
		System.out.println("Extracted char is:"+ch);
		
		int start=s.indexOf('j');
		int end=22;
		
		char aa[]=new char[end - start];
		s.getChars(start, end, aa, 0);
		System.out.println(aa);
	}

}
