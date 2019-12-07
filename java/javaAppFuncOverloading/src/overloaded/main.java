package overloaded;

public class main
{
	public static void main_(String[] args) 
	{
		System.out.println("App Started...");
		try
		{
			int[] arr = {11,22,33,44,55};
			System.out.println(arr[3]);
		
		
			int num1 = Integer.parseInt("2345");
			if(num1>99)
				throw new MyExp("My custom exp, My error msg !!!");
				//throw new MyExp();
				//throw new Exception("Number can't be greater than 99 !!!");
			System.out.println(num1);
			
			int x=5, y=11;
			x=y/x;
			System.out.println(x);
			
			Utility u = null;
			u.setInfo(111, "aaa");
		}
		catch(ArithmeticException ex)
		{
			System.out.println("Some Arithmetic Exception: " +ex.getMessage());
		}
		catch(NumberFormatException nex)
		{
			System.out.println("Invalid Number Format: " + nex.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException aex)
		{
			System.out.println("You went out of Array Index: " + aex.getMessage());
		}
		catch(NullPointerException nex)
		{
			System.out.println("No object found, Null pointer excep: " + nex.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println("Some Unknown Error: " + ex.getMessage());
		}
		System.out.println("App Running ...");
		
		Utility u = new Utility();
		System.out.println("Addition= " + u.Add(22, 33));
	}
	
	
	public static void main2(String[] args) 
	{
		ApplyUtility applyUtility=new ApplyUtility();
		System.out.println("addition="+applyUtility.Add(10, 20));
		System.out.println("addition of 3 num="+applyUtility.Add1(10, 20, 30));
		System.out.println("addition of double num="+applyUtility.Add2(75.54, 54.45));
		System.out.println("concatination of 2 string="+applyUtility.Add_concat_String("dipu", "singh"));
		
		applyUtility.setInfo("tom", 201);
		applyUtility.setInfo(301, "don");
		
	}
	
	public static void main(String[] args) 
	{
		Utility u = new Utility();
		System.out.println("Addition= " + u.Add(22, 33));
		System.out.println("Add= " + u.Add(22, 33, 44));
		System.out.println("Add= " + u.Add(23.68, 44.68));
		System.out.println("Add= " + u.Add("aaa", "bbb"));
		System.out.println(u.Add('a'));
//		System.out.println(u.Add1(10l));
		
		int[] arr = {11,22,33,44,55};
		System.out.println("Add= " + u.Add(arr));
		
//		System.out.println(u.setInfo("jack", 101));
//		System.out.println(u.setInfo(101, "jack"));
	}

}
