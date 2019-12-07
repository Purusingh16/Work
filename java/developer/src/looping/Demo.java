package looping;

public class Demo 
{
	public static void main4(String[] args)
	{
		c1:
			for (int i = 0; i < 3; i++) 
			{
				c2:
					for (int j = 0; j < 3; j++) 
					{
						if(i==j)
						{
							continue;
						}
					System.out.println(i+"\t"+j);
					}
				
			}
	}
	public static void main(String[] args)
	{
		int i=0,j=9;
		do
		{
			i++;
			if(i++>j--)
			{
				break;
			}
		}while(i<=5);
		System.out.println(i+"\t"+j);
	}
	public static void main2(String[] args)
	{
		int i=0;
		while(true)
		{
			if(i==3)
			{
				break;
			}
			i++;
		}
		System.out.println(i);
	}
	public static void main1(String[] args)
	{
		int j=0;
		for (int i = 0; i < 3; i++)
		{
			do
			{
				System.out.println(i);
				//System.out.println(j);
			}while(++j<3);
			
		}
	}
	public static void main0(String[] args) 
	{
		int j=0;
		do
		{
			//for loop will run 3 times here, condition check and increment done at the same time
			//first iteration i=0 ; 0<3 then i++ (post increment) thus i=1
			//second iteration i=1 ; 1<3 then i++ thus i=2
			//third iteration i=2 ; 2<3 then i++ thus i=3
			//fourth iteration i=3 ; 3<3 for loop end then i++ thus i=4
			
			//above steps will run 3 times as for loop is part of while loop
			for (int i = 0; i++<3;)
			{
				System.out.println(i);
			}
			System.out.println("j "+j);
		}
		
		// do while loop will run 3 times here, condition check and increment done at the same time
		//first iteration j=0 ; 0<3 then j++ thus j=1
		//second iteration j=1 ; 1<3 then j++ thus j=2
		//third iteration j=2 ; 2<3 then j++ thus j=3
		// fourth iteration j=3 ; 3<3 while loop end and j++ thus j=4
		while(j++<3);
	}

}
