
public class Main 
{

	public static void main(String[] args)
	{
		System.out.println("Hello World");
		
		System.out.println("percentage:-"+cal_Percentage(375,500));
		
		System.out.println("Circle Area:-"+cal_CircleArea(5));
		
		System.out.println("Rectangle Area:-"+cal_Rect_Area(5,5));
		
		System.out.println("exact_price:-"+cal_Discount(1200,10));
	}
	public static double cal_Percentage(double num,double total_num)
	{
		return (num*100)/total_num;
	}
	public static double cal_CircleArea(double r)
	{
		return 3.14*r*r;
	}
	public static int cal_Rect_Area(int l,int b)
	{
		return l*b;
	}
	public static double cal_Discount(double total_price,double discount)
	
	{
		
		return total_price - ((total_price * discount/100));
		
	}
	
}
