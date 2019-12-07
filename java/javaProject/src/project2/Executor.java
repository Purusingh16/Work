package project2;

public class Executor {
	public static void main(String[] args)
	{
		Rectangle rec=new Rectangle(4,5);
		Circle cir=new Circle(5);
		
		System.out.println("perimter of circle:"+cir.perimeter());
		System.out.println("perimter of Rectangle:"+rec.perimeter());
		
		System.out.println("perimter of Circle:"+cir.area());
		System.out.println("perimter of Rectangle:"+rec.area());
		
		Shape sh=new Rectangle(8,7);
		System.out.println("perimter of Rectangle:"+sh.perimeter());
		System.out.println("perimter of Rectangle:"+sh.area());
		
		  sh=new Circle(10);
		System.out.println("perimter of circle:"+sh.perimeter());
		System.out.println("perimter of circle:"+sh.area());
		
		
	}

}
