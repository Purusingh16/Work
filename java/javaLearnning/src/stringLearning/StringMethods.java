package stringLearning;

public class StringMethods {

	
	public static void main(String[] args) {
		String str1="Hello John Hello";
		String replaceStr1=str1.replace('H','h');
		String replaceStr2=str1.replace("Hello","Hi");
		String replaceStr3=str1.replaceAll("Hello","Hi");
		String replaceStr4=str1.replaceFirst("Hello","Hi");
		
		char charAt=str1.charAt(0);
		int index1=str1.indexOf('H');
//		int index1=str1.indexOf('H');
		
		int index2=str1.indexOf("Hi");
		int index3=str1.indexOf('J', 2);
		int index4=str1.indexOf("hllo", 3);
		
		System.out.println(charAt);
		System.out.println(index1);
		System.out.println(index2);
		System.out.println(index3);
		System.out.println(index4);
		
		
		
		System.out.println(replaceStr1);
		System.out.println(replaceStr2);
		System.out.println(replaceStr3);
		System.out.println(replaceStr4);
		
	}

}
