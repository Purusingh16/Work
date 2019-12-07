package interface_static_default;

public class Main implements MyData
{
	public  boolean isnull(String str) {
		System.out.println("Implements null check");
		
		return str==null ? true : false;
		
	}
	public static void main(String[] args) 
	{
		Main obj= new Main();
		obj.print(" ");
		obj.isnull("str");
		
	}

}
