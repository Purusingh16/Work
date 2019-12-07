package demo2;

public class Main 
{
	public static void main(String[] args) 
	{
		Y ab=new Y();
		Y aa=ab.fun(10, 20);
		System.out.println(ab.i+"\t"+ab.j);
		System.out.println(aa.i+"\t"+aa.j);
		
		Y ss=new Y();
		Y kk=ss.display();
		
		System.out.println(ss.i+"\t"+kk.j);
	}

}
