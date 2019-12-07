package scanner;

public class Main {

	public static void main(String[] args)
	{
		DemoConstructor demoConstructor=new DemoConstructor();
		
		demoConstructor.a=110;
		demoConstructor.b=221;
		
		DemoConstructor demoConstructor2=new DemoConstructor(45, 56);
		
		System.out.println("value of variable a before calling set  method:"+demoConstructor2.a);
		System.out.println("value of variable b before calling set  method:"+demoConstructor2.b);
		
		
		demoConstructor2.setFirst(20);
		demoConstructor2.setSecond(40);
		
		System.out.println("value of variable a after calling set  method:"+demoConstructor2.getFirst());
		
		System.out.println("value of variable a after calling set  method:"+demoConstructor2.a);
		System.out.println("value of variable b after calling set  method:"+demoConstructor2.b);
	}

}
