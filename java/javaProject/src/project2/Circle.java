package project2;

public class Circle extends Shape {
	 
	 public Circle(double radius)
	 {
		 this.radius=radius;
	 }
	 double radius;
	@Override
	double area() {
		double a=Math.PI*radius*radius;
		return a;
	}

	@Override
	double perimeter() {
		double p=2*Math.PI*radius;
		return p;
	}
	
}
