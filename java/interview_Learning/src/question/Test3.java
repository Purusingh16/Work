package question;

public class Test3 
{
	int GetValue()
	{
		return(true?null:0);
	}
	public static void main(String[] args) 
	{
		Test3 obj=new Test3();
		obj.GetValue();
	}

}
