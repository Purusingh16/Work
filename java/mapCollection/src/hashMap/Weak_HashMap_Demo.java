package hashMap;

import java.util.HashMap;
import java.util.WeakHashMap;

public class Weak_HashMap_Demo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception 
	{
		WeakHashMap m=new WeakHashMap();
		Temp t=new Temp();
		m.put(t, "durga");
		System.out.println(m);
		t=null;
		System.gc();
		Thread.sleep(5000);
		System.out.println(m);
	}

}
