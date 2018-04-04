package cs598ga.shull.test.runtime;

public class PrologRuntime {
	public static void programError(){
		throw new Error("program error occurred");
	}

	public static void programError(String message){
		System.out.println(message);
		throw new Error("program error occurred");
	}

	public static void testAssert(boolean check){
		if(!check){
			throw new Error("test assert failed");
		}
	}

	public static void testAssert(boolean check, String message){
		if(!check){
			System.out.println(message);
			throw new Error("test assert failed");
		}
	}

}
