package constructor_nonstatic;

public class Text 
{
	void Text()
	{
		System.out.println("java");
	}
	public static void main(String[] args)
	{
		Text tt=new Text();
		tt.Text();
	}

}
