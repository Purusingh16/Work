package oops;

public class MethodVisibility {

	
	public static void main(String[] args) {
		A superClass=new B();
		B subClass=new B();
//	B subClass_2=(B)new A();
		superClass.a(4);
		superClass.a("print");
//		superClass.d();
		subClass.b();
		

	}

}
class A{
	void a(int i){
		
	}
//	visible to subclass object
	void b()
	{
		
	}
	void a(String b){
		System.out.println(b);
		
	}
}
class B extends A{
	void a(int k){
		System.out.println("in subclass"+k);
		
	}
//	not visible to superclass reference or object
	void d(){
		
		
	}
	
}