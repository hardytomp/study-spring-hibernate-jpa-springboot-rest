
public class StaticTest {
	
	final int staticVal;
	static final int staticVal2;
	static final int staticVal3 =3;
	
	public StaticTest() {
		System.out.println("constructor");
		staticVal =1;
	}
	
	static {
		staticVal2 =2;
//		staticVal3 = 5;
		System.out.println("static block");
	}
	
	public void statictest() {
	//	staticVal3 = 5;
	}
	
	public static void main(String[] args) {
		System.out.println("main");
		StaticTest test = new StaticTest();
	}
	

}
