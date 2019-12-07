package interfaceProject1;

public class Text implements Inter11 {

	@Override
	public void show() {

	}

	@Override
	public void display() {

	}

	public static void main(String[] args) {
		Inter11 ii=new Inter11(){
			public void show() {
				System.out.println("Annonymous inner class");
			}
			@Override
			public void display() {
				System.out.println("construct object of interface");
			}
		};
		ii.show();
		ii.display();
	}

}
