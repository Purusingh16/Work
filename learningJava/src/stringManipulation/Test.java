package stringManipulation;

public class Test 
{
	Test(String str)
	{
		
	}

	public static void main(String[] args) 
	{
		String s1="ratan";
		String s2="anu";
		String s3="ratan";
		Test t =new Test("dipu");
		Test t1=new Test("dipu");
		System.out.println(t.equals(t1));
		
		System.out.println(s1.equals(s2));//false	
		System.out.println(s1.equals(s3));//true
		System.out.println(s3.equals(s2));//false
		
		int[] a=new int[112330];
		System.out.println(a.length);
		
		String str="Purushottam";
		System.out.println(str.length());
		
	}

}
