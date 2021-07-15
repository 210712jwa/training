
public class Demo {

	public static void main(String[] args) {
		// switch is a way to execute a block of code based on the value that a variable matches
		// the variable you can use with a switch statement can only be
		// byte, short, char, int (and their wrapper classes)
		// String
		// Enums
		
		int month = 4;
		switch (month) {
			case 1:
				System.out.println("It is January");
				break;
			case 2:
				System.out.println("It is February");
				break;
			case 3:
				System.out.println("It is March");
				break;
			case 4:
				System.out.println("It is April");
				break;
			case 5:
				System.out.println("It is May");
				break;
			case 6:
				System.out.println("It is June");
				break;
			default:
				System.out.println("It is not a month between January and June inclusive");
				break; // break is optional here because this is the last "case"
			// If we do not use the break keyword, it is known as "fall-through"
		}

	}

}
