package constProject;

public class Main 
{
	public static void main(String[] args) 
	{
		Y ab=new Y();
		Y ab1=ab.showdata("dipu", 201);
		
		System.out.println(ab1.name+"\t"+ab1.roll);
		System.out.println(ab.name+"\t"+ab.roll);
		
		Y tt=(Y) ab.extract("dipu singh", 501);
		System.out.println(tt.name+"\t"+tt.roll);
		System.out.println(ab.name+"\t"+ab.roll);
	}

}
