package array;

public class source {

	public static void main1(String[] args) 
	{
		Ball b=new Ball();
		b.play();
		b.radius=8;
		System.out.println("ball radius:"+b.radius);
		
		
		System.out.println("calculate volume:"+b.CalVolume());
		b.color="blue";
		System.out.println("ball color:"+b.color);
		
		System.out.println(b.showBallInfo());
	}
	
	public static void main(String[] args) 
	{
		int[] arr={10,20,30,40,50};
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for(int num:arr)
		{
			System.out.println(num);
		}
		String[] cities={"bombay","pune","delhi","patna","motihari"};
		
		for(String city:cities)
		{
			System.out.println(city);
		}
		
	}

}
