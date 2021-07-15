
public class Demo {

	public static void main(String[] args) {
		
		// instanceof
		// Used to see if a particular object that a reference variable is pointing to is of a certain type
		String s = "hello";
		System.out.println(s instanceof Object);
		Object o = s;
		System.out.println(o instanceof String);
		
		// AND and OR logical operators
		// Two types:
		// 1. Non short circuiting operators ( | and & ): both sides get evaluated no matter what
		// 2. Shortcircuiting operators ( || and && ): sometimes the right side is not evaluated because it is obvious in certain
		// cases what the final result is
		
		System.out.println(returnTrue() | returnTrue());
		
		System.out.println(returnTrue() || returnFalse());
		
		System.out.println(returnFalse() & returnFalse());
		
		System.out.println(returnFalse() && returnTrue());
		
		// In this case, we can't short circuit, because the left side is true, therefore we need to check if the right side is also true
		// for the operation to evaluate to true, or if the right side is false, to evaluate to false
		System.out.println(returnTrue() && returnTrue());
		
		System.out.println(!true); // false
		System.out.println(!false); // true
	}
	
	public static boolean returnTrue() {
		System.out.println("returnTrue() invoked");
		return true;
	}
	
	public static boolean returnFalse() {
		System.out.println("returnFalse() invoked");
		return false;
	}
}
