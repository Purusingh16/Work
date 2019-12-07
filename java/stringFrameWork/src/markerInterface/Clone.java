package markerInterface;

public class Clone implements Cloneable 
{
	String name;
	int roll;
	
	Clone(String name,int roll)
	{
		this.name=name;
		this.roll=roll;
	}
	public static void main(String[] args) 
 
	{
		Clone c1=new Clone("java",101);
		
		Clone c2;
		try {
			c2 = (Clone) c1.clone();
			

			System.out.println(c1.name+"\t"+c1.roll);
			System.out.println(c2.name+"\t"+c2.roll);
			
			System.out.println(c2.hashCode()+"\t"+c1.hashCode());
			
			if (c1.equals(c2)) 
			{
				System.out.println("Equals");
			}else
			{
				System.out.println("Not Equals");
			}

		} catch (CloneNotSupportedException e) 
		{
			System.out.println("Object is Clone");
			e.printStackTrace();
		}
	}

}
