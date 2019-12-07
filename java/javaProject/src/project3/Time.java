package project3;

public class Time {

	int hours;
	int minutes;
	int seconds;
	/*public Time(int hours, int minutes, int seconds)
	{
	this.hours=hours;
	this.minutes=minutes;
	this.seconds=seconds;
}*/
	public  void setHours(int hours) 
	{
		if (hours < 0 || hours > 23)
		{
			System.out.println(hours + " is invalid value for hours");
		}
		else
		{
			System.out.println(hours + " is valid for hours");
			this.hours = hours;
		}
	}
	
	public int getHours() 
	{
		return hours;
	}
	
	public void setMinutes(int minutes) 
	{
		if (minutes < 0 || minutes > 59)
		{
			System.out.println(minutes + " is invalid value for minutes");
		}
		else 
		{
			System.out.println(minutes + " is valid for minutes");
			this.minutes = minutes;
		}
	}

	public int getMinutes()
	{
		return minutes;
	}

	public void setSeconds(int seconds) 
	{
		if (seconds < 0 || seconds > 59)
		{
			System.out.println(seconds + "is invalid value for seconds");
		}
		else 
		{
			System.out.println(seconds + "is valid value for seconds");
			this.seconds = seconds;
		}
	}

	public int getSeconds() 
	{
		return seconds;
	}

	public static void main(String[] args) {
		/*Time time=new Time(12,34,45);
		int hours=time.getHours();
		int minutes=time.getMinutes();
		int seconds=time.getSeconds();
		
		System.out.println(hours+" "+minutes+" "+seconds);*/
		
		Time t = new Time();
		t.setHours(12);
		t.setMinutes(60);
		t.setSeconds(60);
//		t.setHours(-2);
//		t.setMinutes(30);
//		t.setSeconds(50);
		int hours1 = t.getHours();
		int minutes1 = t.getMinutes();
		int seconds1 = t.getSeconds();
		System.out.println(hours1);
		System.out.println(minutes1);
		System.out.println(seconds1);

	}
}