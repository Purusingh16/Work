package referencePart1;

public class Child extends Base
{
	Base display(String s,int r)
	{
		Child ch=new Child();
		ch.name=s;
		ch.roll=r;
		
		return ch;

	}

}
