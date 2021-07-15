package datatypes;

public class Demo {

	public static void main(String[] args) {
		// Variables in Java can either be
		// 1. A primitive
		// 2. A reference type
		
		// Today we'll basically be looking at primitive types
		
		// Primitive Types
		
		// INTEGRAL TYPES
		// 1. byte (8 bits) -128 to 127
		// 2. short (16 bits) -32768 to 32767
		// 3. char (16 bits) <- used primarily for characters 'a', 'b', 'E', '@', etc., but can also store numbers (0 to 65535)
		// 4. int (32 bits) <- -2,147,483,648 to 2,147,483,647
		// 5. long (64 bits) <- -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
		
		// FLOATING POINT TYPES
		// 6. float (32 bits) <- +- 3.40282347 * 10^38
		// 7. double (64 bits) <- +- 1.7976931... * 10^308
		
		// 8. boolean (true, false), in terms of bits, depends on the JVM, but theoretically, we should only require 1 bit
		
		byte a; // declaring a variable, the JVM will allocate memory for this variable without any value for the variable yet.
		a = 10; // assignment, we are actually assigning a value to an already existing variable
		
		byte b = 15;
		
		System.out.println("a: " + a); // "a: " is a "string literal"
		System.out.println("b: " + b);
		
		short c = 30000;
		char d = '$'; // '$' is a "char literal"
		char f = 1000;
		int g = 243_123_324;
		long h = 4444444444444L; // Long literal, postfixed with an L
		float i = 10.3f; // float literals need to be postfixed with an f
		double j = 12.323;
		boolean k = true;
		boolean l = false;
		
		// Typical arithmetic
		// Addition (+)
		// Subtraction (-)
		// Multiplication (*)
		// Division (/)
		// Modulus (%) 4 % 3 = 1
		
		byte a1 = 10;
		byte a2 = 20;
		
		// Automatic promotion
		// Whenever I have a binary operation, adding, subtracting, multiplying, etc.
		// What happens is if the primitives are less than an int (byte, short, char)
		// The operation will automatically be converted to an int
		byte a3 = (byte) (a1 + a2);
		
		// Casting is where we convert from one type to another
		// For example, in the case above, we need to convert the result of a1 + a2, which is going to be an int
		// due to "automatic promotion" back to a byte, so that it can be assigned to the a3 variable
		
		int b1 = 100343432;
		byte b2 = (byte) b1; // Casting from int to byte (this is considered an unsafe operation, so we have to do it explicitly)
		// This is a narrowing conversion, because we're going from a type with a wider range to a type with a smaller range
		// It simply truncates the leftmost bits until we end up with only the bits that that type has. (cuts off leftmost 24 bits)
		// (leaves us with 8 bits on the right), so the result could be unpredictable
		System.out.println("b2: " + b2);
		
		int c1;
		byte c2 = 50;
		c1 = c2; // We are casting from a byte to an int
		// This can happen implicitly, because it is a "safe" operation
		// This is known as a widening conversion, because we're going from a type with a narrow range to a type with a wider range
		
		double d1 = 11 / 2;
		// 11 is an int
		// 2 is an int
		// therefore, the result of 11 / 2 is an int
		// 11 / 2 = 5
		// 5 then gets converted into a double: 5 -> 5.0
		System.out.println("d1: " + d1); // So here we print out 5.0
		
		double d2 = 11.0 / 2;
		// 11.0 is a double
		// 2 is an int
		// therefore, 2 gets "casted" into a double: 2 -> 2.0
		// 11.0 / 2.0 -> 5.5
		System.out.println("d2: " + d2);
		
		// Increment / Decrement
		// ++, --
		// variable x
		// x++, x-- <= postfix operators
		// ++x, --x <= prefix operators
		int e = 0;
		System.out.println("e++: " + e++); // e++ is both an expression and an operation, this expression evaluates to the value of e
		// BEFORE incrementing
		System.out.println("e: " + e);
		
		System.out.println("++e: " + ++e);
		System.out.println("e: " + e);
		
		// Compound assignment operators
		int x = 10;
		x += 2; // increase x by 2 (x = x + 2)
		x -= 2; // decrease x by 2 (x = x - 2)
		x /= 2; // x = x / 2
		x *= 2; // x = x * 2
		x %= 2; // x = x % 2
		System.out.println(x);
		
		// Operator precedence
		// Generally follows the same rules as you would have seen in algebra class
		// PEMDAS
		System.out.println(2 + 2 * 3);
		System.out.println(1 + 2 < 5 + 3);
	}
	// ctrl + space <- autosuggestion

}
