
public class Sample {
	public static void sample(){
		synchronized(Sample.class) {
			System.out.println("sample");
		}
	}
	
	public void nonSample() {
		synchronized (Sample.class) {
			System.out.println("non sample");
		}
	}

}
