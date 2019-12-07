package stringLearning;

public class ImplementedClass extends AbstractSubClass {

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
public int sub2(int i,int j){
	return 0;
}
public static void main(String[] args)
{
//	AbstractClass first=new ImplementedClass();
	
	ImplementedClass ref=new ImplementedClass();
	AbstractOperation first = null;
	System.out.println(first.add(0,1));
}
}
