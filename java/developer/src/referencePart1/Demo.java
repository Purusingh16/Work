package referencePart1;

public class Demo 
{
	public static void main(String[] args) 
	{
		Child ch1=new Child();
		Child ch2=(Child)ch1.display("raj", 34);
		System.out.println(ch1.name+"\t"+ch1.roll);
		System.out.println(ch1.name+"\t"+ch1.roll);
	}

}
