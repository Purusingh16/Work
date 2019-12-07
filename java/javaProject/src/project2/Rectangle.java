package project2;

public class Rectangle extends Shape{
	public Rectangle(double length,double width){
		this.length=length;
		this.width=width;
	}
	double length;
	double width;
	@Override
	double area() {
		double a=length*width;
		return a;
	}

	@Override
	double perimeter() {
		double p=2*(length+width);
		return p;
	}

}