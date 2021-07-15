
public class Example {

	public static void main(String[] args) {
		// write a method that checks to see if a certain number is prime or not
		boolean prime = isPrime(1);
		System.out.println(prime);
	}
	
	public static boolean isPrime(int number) {
		if (number <= 1) return false; // if you have a single statement, you
		// can do a one liner
		
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		
		return true;
	}

}
