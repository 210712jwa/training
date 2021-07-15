import java.util.Arrays;

public class Demo {

	public static void demo() {
		// Array variable declarations
		int myIntArray[];
		int[] myOtherIntArray; // This way is more popular and typical
		int x = 10;
		
		// The 2 variables above are reference variables to an Array object
		// We can think of Arrays as being objects in memory (heap)
		myIntArray = new int[5]; // Here we are saying, create a new int array object of size 5 in the heap
		// and have myIntArray, which is a variable in the stack, point to the location of the int array in the heap
		
		// Upon instantiation of a primitive array, we would have default values (if we don't do any prepopulating)
		// 0 or 0.0 for numbers
		// false for boolean
		
		myOtherIntArray = myIntArray;
		myOtherIntArray[0] = 100;
		
		System.out.println(myIntArray[0]);
		
		System.out.println(myIntArray); // prints out '[I@<location of int array>'
		System.out.println(Arrays.toString(myIntArray));
		// sysout, then type ctrl + space
		
		myOtherIntArray = new int[] { 100, 56, 42, 1000, 324 };
		System.out.println(Arrays.toString(myOtherIntArray));
		System.out.println(myOtherIntArray.length);
		
		// Shorthand for declaring an array variable and instantiating an array on the same line
		char[] myCharArray = { 'a', 'b', 'c' };
		
		// iterating over array w/ for loop
		for (int index = 0; index < myCharArray.length; index++) {
			System.out.println("value at index " + index + " : " + myCharArray[index]);
		}
		
		// enhanced for loop
		for (char c : myCharArray) {
			System.out.println(c);
		} // enhanced for loop is more convenient, but less flexible
		// for example, we don't have access to indices, and we can't control the direction of iteration
		
		// We wouldn't be able to do a reverse traversal of the array like we can here
		for (int i = myCharArray.length - 1; i >= 0; i--) {
			System.out.println(myCharArray[i]);
		}
		
		/*
		 * Reference type arrays
		 */
		// We can have arrays that contain many references to objects stored in the heap
		// For example, Strings are objects
		String[] names = new String[3];
		// default value at instantiation for elements of a reference type array is null
		System.out.println(Arrays.toString(names));
		names[0] = "John";
		names[1] = "Jose";
		names[2] = "Mary";
		System.out.println(Arrays.toString(names));
		
		for (String name : names) {
			System.out.println(name);
		}
		
		// multi-dimensional arrays
		int[][] the2DArray = new int[][] { {1, 2, 3, 4}, {5, 6, 7, 8, 10, 12, 123, 11}, {9, 10, 11, 12} };
		System.out.println(the2DArray[2][1]);
		
		// Nested for loops to traverse through a 2D array
		for (int i = 0; i < the2DArray.length; i++) {
			for (int j = 0; j < the2DArray[i].length; j++) {
				System.out.println("i: " + i + ", j: " + j + " : " + the2DArray[i][j]);
			}
		}
		
		// enhanced for loop
		for (int[] row : the2DArray) {
			for (int number : row) {
				System.out.println(number);
			}
		}
	}
	
}
