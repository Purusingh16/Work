package project_Interface;
interface Left
{
//	public void m1();
	int x=777;
		
}
interface Right
{
//	public void m1(int i);
//	public int m1();
	int x=888;
}


  class Test1 implements Left,Right
 {
	/* public void m1()
	 {
		 
	 }
	 public void m1(int i) 
	 {
		 
	 }

 }*/
	public static void main(String[] args)
	{
		System.out.println(Left.x);
		System.out.println(Right.x);
	}

}
