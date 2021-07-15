
public class Demo {

	public static void main(String[] args) {
		// Control flow is the concept whereby we control whether certain code executes
		// or not based on certain conditions being met
		// This is important in programming, because if you do not have control flow,
		// things always happen the same everytime

		// What we will cover today
		// 1. if
		// 2. if - else
		// 3. if - else chaining
		// 4. ternary operator

		// What will be covered later
		// 1. while loop
		// 2. do-while loop
		// 3. for loop
		// 4. enhanced for loop
		// 5. switch

		/*
		 * If
		 */
		int age = 17;
		// Boolean comparison operators
		// < (less than)
		// > (greater than)
		// <= (less than or equal to)
		// >= (greater than or equal to)
		// == (equals)
		// != (not equals)
		if (age < 18) {
			System.out.println("The person is a minor");
		}

		/*
		 * If - else
		 */
		if (age >= 18) {
			System.out.println("The person is an adult");
		} else {
			System.out.println("The person is a minor");
		}

		/*
		 * If else chaining
		 * 
		 * Think of this as a series of mutually exclusive code blocks Only one of these
		 * code blocks will ever execute
		 */
		age = 30;
		if (age < 0) {
			System.out.println("Invalid age");
		} else if (age < 18) {
			System.out.println("The person is a minor");
		} else if (age < 45) {
			System.out.println("The person is a young adult");
		} else if (age < 65) {
			System.out.println("The person is a middle aged adult");
		} else {
			System.out.println("The person is of retirement age");
		}

		/*
		 * Nested if statements
		 */
		String gender = "male"; // A String is a an object representing a series of characters
		// Think of it as basically being an array of chars
		// Strings are not primitives in Java, but we're going to use a String here
		// because they're so commonly used anyways

		// ctrl + shift + f can be used to automatically format our code to look nice
		if (age >= 18) {

			if (gender.equals("male")) {
				System.out.println("The person is a man");
			} else {
				System.out.println("The person is a woman");
			}

		} else {

			if (gender.equals("male")) {
				System.out.println("The person is a boy");
			} else {
				System.out.println("The person is a girl");
			}

		}
		
		/*
		 * Ternary operator
		 * 
		 * This is how you can use conditions in the form of an expression
		 * 
		 * the format is <condition> ? <expression if true> : <expression if false>
		 */
		String ageGroup = age >= 18 ? "adult" : "minor";
		System.out.println(ageGroup);
		
		// Scope
		// Scope is all about the context in which a variable exists
		// 
		// (here we will demonstrate block scope)
		
		if (age > 18) {
			int x = 10;
			
			System.out.println(x);
			
			System.out.println(age); // This is still possible, because age was defined in an outer scope (method scope)
		}
		System.out.println(age); // this is possible because we are in the same scope as age
		
		// This line of code would not compile because x does not exist outside of the context of the if block above
//		System.out.println(x);
	}

}
