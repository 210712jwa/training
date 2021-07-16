package com.revature.app;

public class Application {

	public static void main(String[] args) {
//		stringDemo();

		String myString = "apricot";

		// String
		long startingTime = System.nanoTime();
		System.out.println(stringReverseDemo(myString));
		long endingTime = System.nanoTime();
		System.out.println("stringReverseDemo took " + (endingTime - startingTime) + " ns");

		// StringBuilder
		long startingTime2 = System.nanoTime();
		System.out.println(stringBuilderReverseDemo(myString));
		long endingTime2 = System.nanoTime();
		System.out.println("stringBuilderReverseDemo took " + (endingTime2 - startingTime2) + " ns");

		// StringBuffer
		long startingTime3 = System.nanoTime();
		System.out.println(stringBufferReverseDemo(myString));
		long endingTime3 = System.nanoTime();
		System.out.println("stringBufferReverseDemo took " + (endingTime3 - startingTime3) + " ns");
		
	}

	public static String stringReverseDemo(String originalString) {
		String reversedString = "";

		for (int i = originalString.length() - 1; i >= 0; i--) {
			reversedString += originalString.charAt(i); // String concatenation
//			 String + char -> char gets converted into a String -> String + String = a new String
//			 Every time String concatenation occurs, a new String object is created (because Strings
//			 are immutable)
//			 That is very inefficient
		}

		return reversedString;
	}

	public static String stringBuilderReverseDemo(String originalString) {
		StringBuilder sb = new StringBuilder();

		for (int i = originalString.length() - 1; i >= 0; i--) {
			sb.append(originalString.charAt(i));
		}

		return sb.toString();
	}

	public static String stringBufferReverseDemo(String originalString) {
		StringBuffer sb = new StringBuffer();

		for (int i = originalString.length() - 1; i >= 0; i--) {
			sb.append(originalString.charAt(i));
		}

		return sb.toString();
	}

	public static void stringDemo() {
		// Declare and initialize Strings using String literals
		String str1 = "hi";
		String str2 = "hi";
		// str1 and str2 reference variables will be "pointing" to the same "hi" object
		// located in the String pool

		// Whenever Java encounters String literals inside of our program (no matter
		// where it is
		// written), it will create an object in the String pool, unless one already
		// exists
		// with that value

		// How do we know str1 and str2 are pointing to the same object?
		// with reference variables, we can use ==
		System.out.println("str1 == str2: " + (str1 == str2));

		// ==
		// Primitives v. Reference variables
		// For primitives, == will compare the values of the two to see if they are
		// equal
		// For reference variables, == will compare to see if they are pointing to the
		// same object

		String str3 = new String("hi");
		System.out.println("str3 == str2: " + (str3 == str2));

		// String concatenation
		System.out.println("1" + 1 + 1); // "1" + 1 + 1 -> "11" + 1 -> "111"
		System.out.println(1 + "2" + 3); // "123"
		System.out.println(1 + 1 + "2"); // "22"

		System.out.println("Hello " + "World");

		// concat
		String concatExample = "h".concat("i"); // All methods that return a String will be referencing
		// a String object in the regular part of the heap
		System.out.println("concatExample == \"hi\" " + (concatExample == "hi"));
		System.out.println("concatExample.equals(\"hi\") " + concatExample.equals("hi"));

		// charAt
		String str4 = "Hello World";

		char c1 = str4.charAt(4);
		System.out.println(c1 == 'o'); // true
		System.out.println(c1); // o

		// indexOf
		System.out.println(str4.indexOf("World")); // 6

		// length
		System.out.println(str4.length()); // 11

		// substring
		System.out.println(str4.substring(2));
		System.out.println(str4.substring(2, 4));

		// equals
		System.out.println(str3 == str2); // str2 is pointing to a String object in the string pool
		// str3 is pointing to a String object in the regular part of the heap
		// so str3 == str2 is false

		// Meanwhile, if we actually want to compare the values of str3 and str2, rather
		// than
		// seeing if they point to the same object, we can use the .equals(String s)
		// method
		System.out.println(str3.equals(str2)); // true, because they both have the value "hi"

		// startsWith
		System.out.println(str4.startsWith("Hello"));

		// endsWith
		System.out.println(str4.endsWith("World"));

		// compareTo
		System.out.println("apple".compareTo("apricot"));
		// compareTo returns an int
		// If the number is less than 0, the string "apple" comes before "apricot"
		// if it is 0, they are equal
		// if it is > 0, "apple" comes after "apricot"
		// The number returned is -2, so apple does indeed come alphabetically before
		// apricot
	}

}
