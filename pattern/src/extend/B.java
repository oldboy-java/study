package extend;

public class B extends A {
	
	{System.out.println("in class B");}
	
	static {
		System.out.println("in class B of static block");
	}
	
	
	public B(){
		System.out.println("in B Constructor ");
	}
	
	public void a(){
		System.err.println(" in B");
	}
	
	
	public static void main(String[] args) {
		new B();
	}
	
}
