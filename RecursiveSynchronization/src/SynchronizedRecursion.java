
public class SynchronizedRecursion {

	public synchronized void test() {
		System.out.println("test");
		test();
	}
	
	
	public static void main(String args[]) {
		SynchronizedRecursion obj = new SynchronizedRecursion();
		obj.test();
	}
}
