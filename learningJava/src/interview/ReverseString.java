package interview;

public class ReverseString {
	
	public static void main(String[] args)
	{
		String str="hello hi hola";
		
		System.out.println("before reverse:"+str);
		
		String strRev=" ";
		
		for (int i = str.length()-1; i >=0; i--) 
		{
			strRev=strRev+str.charAt(i);
		}
		System.out.println("after reverse:"+strRev);
		
	}

	public static void main0(String[] args) {
		String str = "purushottam";
		
		int count = str.length();
		
		for (int i = count-1; i>=0 ; i--) {
			char str1 = str.charAt(i);
			
			System.out.print(str1);
		}
		
	}

}
