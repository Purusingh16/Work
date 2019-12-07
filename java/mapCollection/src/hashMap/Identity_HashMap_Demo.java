package hashMap;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class Identity_HashMap_Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		IdentityHashMap ihm=new IdentityHashMap();
		Integer i1=new Integer(10);
		Integer i2=new Integer(10);
		
		ihm.put(i1, "pawan");
		ihm.put(i2, "kalyan");
		
		System.out.println(ihm);
		
	}
	public static void main0(String[] args) {
		HashMap m=new HashMap();
		Integer i1=new Integer(10);
		Integer i2=new Integer(10);
		
		m.put(i1, "pawan");
		m.put(i2, "kalyan");
		
		System.out.println(m);
		
	}

}
