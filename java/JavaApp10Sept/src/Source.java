import java.util.Scanner;


public class Source {

	public static void main(String[] args) 
	{
//		System.out.println(args.length);
		
		Scanner sc=new Scanner(System.in);
		/*System.out.println("Enter Name:");
		String name = sc.next();
		System.out.println("Enter Age:");
		int age=0;
		if(sc.hasNextInt())
			age= sc.nextInt();
		
		System.out.println(name +" "+ age);*/
		
		System.out.println("Enter num1");
		int num1=sc.nextInt();
		System.out.println("Enter num2");
		int num2=sc.nextInt();
		
		
		int avg = average(num1,num2);
		System.out.println("total average:"+avg);
		
		double rad=0.0;
		System.out.println("Enter Radius:");
		if(sc.hasNextDouble())
			rad = sc.nextDouble();
		System.out.println("Area of Circle= " + cal_circle_Area(rad));
		
	}
	
	 public static double cal_circle_Area(double radius)
	 {
		 return 3.14 * radius * radius;
	 }
	
	public static int average(int num1,int num2)
	{
		return (num1+num2)/2;
	}

}

