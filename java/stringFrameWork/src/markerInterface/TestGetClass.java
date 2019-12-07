package markerInterface;

public class TestGetClass
{

	public static void main(String[] args)
	{
		String s1=new String("java");
		Class c1=s1.getClass();
		
		System.out.println("Name of the class is:"+c1.getName());
		try {
			String ss=(String) c1.newInstance();
			System.out.println(ss);
			} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			
		

	}

}
