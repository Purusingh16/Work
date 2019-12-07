package non_static_innerClass;

public class Main {

	public static void main(String[] args)
	{
		SubClass1 obj1=new SubClass1();
		SubClass1.SubClass2 obj2=obj1.new SubClass2();
		obj2.m2();//method call
		
//		obj1.obj2.m2();
		
	}

}
