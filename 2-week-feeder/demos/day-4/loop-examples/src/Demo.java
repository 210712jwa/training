
public class Demo {

	public static void main(String[] args) {
		/*
		 * Loops
		 * 
		 * - for loops
		 * - while loops
		 * - do while loops
		 */
		
		/*
		 * For loops
		 */
		for (int i = 0; i < 1000; i++) {
			System.out.println("The value of i: " + i);
		}
		
		for (int i = 5; i > 0; i--) {
			System.out.println("The value of i: " + i);
		}
		
		for (int i = 0; i < 100; i += 3) {
			System.out.println("The value of i: " + i);
		}
		
		/*
		 * While loop
		 */
		int number = 100;
		while (number > 0) {
			System.out.println("number: " + number);
			number--;
		}
		System.out.println(number);
		
		/*
		 * Do-while loop
		 * 
		 * Do-while loops always execute at least once
		 * v. a while loop, which will check the condition first, and if it is false to begin with, not execute at all
		 */
		number = 0;
		do {
			System.out.println("number: " + number);
			number--;
		} while (number > 0);
		
		System.out.println(number);
		
		/*
		 * break, continue keywords
		 */
		
		// break
		for (int i = 1; i < 10; i++) {
			System.out.println("i: " + i);
			
			if (i == 5) {
				break;
			}
		}
		
		System.out.println("==================");
		// continue
		for (int i = 1; i < 100; i++) {
			
			if (i % 2 == 1) {
				continue; // continue onto the next iteration if the number is odd
				// continue skips all of the rest of the code in the current iteration and just moves to the next
			}
			
			System.out.println("i: " + i);
		}
		
		// labels
		exampleLabel:
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (j == 5) {
						continue exampleLabel;
					}
					
					System.out.println("i: " + i + ", j: " + j);
				}
			}
	}

}
