package stringLearning;

public class FinalKeyword {

	final int var = 0;
	
	final a obj=new a();

	public static void main(String[] args) {

		FinalKeyword f = new FinalKeyword();
//		f.obj=new b();
//		f.var=2;
	}

}

class a {
 private c add(int a,int b)
	{
		System.out.println("in super class");
		return new c();
	}
	public void add(float a,int b)
	{
		System.out.println("method overloading");
	}
}

class b extends a{
	
	d add( int a,int b){
		System.out.println("in subclass");
		return new d();
		
		
	}

}

class c{
	
}
class d extends c{
	
}