package non_static_inner_class_sup_inheritence;
//how non-static inner class support inheritence?
public class Outer 
{
	String name;
	int roll;
	
	class Inner
	{
		public void setName(String name)
		{
			Outer.this.name=name;
		}
	}
	public class Inner2 extends Inner 
	{
		public void setRoll(int roll)
		{
			Outer.this.roll=roll;
		}

	}
	

}
