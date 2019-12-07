package constructor_nonstatic;

public class Text1
{
	public  void text1(int data)
	{
		System.out.println("java");
	}

	public static void main(String[] args) 
	{
		Text1 tt=new Text1();
		tt.text1(0);
	}
	Text1()
	{
		System.out.println("object is constructed");
	}

}
