package interview;

public class FabSeries 
{
	 public static int f1,f2,f3;
	 
	 public static void getFabSeries(int count)
	 {
		 if(count>0)
		 {
			 f3=f1+f2;
			 
			 f1=f2;
			 f2=f3;
			 
			 System.out.print(" "+f3);
			 
			 getFabSeries(count-1);
			 
		 }
	 }

	public static void main(String[] args)
	{
		int count=10;
			
		f1=0;
		f2=1;
		
		
		System.out.print(f1+" "+f2);
		
		getFabSeries(count-2);
	}

}
