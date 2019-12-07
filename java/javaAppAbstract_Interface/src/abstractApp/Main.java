package abstractApp;

import java.util.ArrayList;

public class Main 
{
	public static void main7(String[] args)
	{
		ArrayList<IShape> ilist=new ArrayList<>();
		ilist.add(new CRect("r1", 11, 10));
		ilist.add(new CTraingle("t1", 10, 30));
		ilist.add(new CSquire("sq", 10));
		
		for (IShape i1 : ilist) 
		{
			System.out.println(i1.GetInfo()+",Area ="+i1.CalArea());
		}
	}
	
	public static void main(String[] args)
	{
		//Shape s = new Shape("dddd");
		//IShape s1 = new IShape();
		IShape s = new CRect("r1", 11, 10);
		System.out.println(s.GetInfo() + ", Area=" + s.CalArea());
		
		IShape s1=new CTraingle("t1", 10, 30);
		System.out.println(s1.GetInfo()+", Area="+s1.CalArea());
		
		IShape s2=new CSquire("sq", 10);
		System.out.println(s2.GetInfo()+",Area="+s2.CalArea());
	}
	
	public static void main5(String[] args)
	{
		ArrayList<Shape> slist=new ArrayList<>();
		slist.add(new Rect("r1", 20, 40));
		slist.add(new Circle("c1", 10));
		slist.add(new Traingle("t1", 20, 60));
		
		for (Shape s : slist) 
		{
			System.out.println(s.getInfo());
			System.out.println("area="+s.calArea());
		}
		
	}
	public static void main1(String[] args)
	{
		Shape[] slist=new Shape[3];
		slist[0] =new Rect("r1", 20, 40);
		slist[1] =new Circle("c1", 10);
		slist[2] =new Traingle("t1", 20, 60);
		
		for (int i = 0; i < slist.length; i++) 
		{
			System.out.println(slist[i].getInfo());
			System.out.println("area="+slist[i].calArea());
		}
	}
}
