package array;

public class Ball 
{
	int radius;
	String color;
	
	void play()
	{
		System.out.println("playing with ball!!");
	}
	double CalVolume()
	{
		return 3.14*radius*radius*radius;
	}
	String showBallInfo()
	{
		return "radius="+this.radius+" color="+this.color;
	}
}
