package javaAssignment;

public class AddDigitofNum {

//	int sum=0;
//	int num=321;
	public static void main(String[] args) {
		
		int sum=0;
		int num=321;
//		String a[]={"zero","one","two","three"};
		while(num>0)
		{
			sum=sum+num%10;
			num=num/10;

		}
		
//		System.out.println(a[3]+" "+a[2]+" "+a[1]+" "+a[0]);
		System.out.println(sum);
		

	}

}
