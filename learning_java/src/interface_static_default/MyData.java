package interface_static_default;

public interface MyData 
{
	public default void print(String str) {
		if (!isNull(str))
			System.out.println("MyData Print::" + str);
	}

	public static boolean isNull(String str) {
		System.out.println("Interface Null Check");

		return str == null ? true : false;
	}

}
