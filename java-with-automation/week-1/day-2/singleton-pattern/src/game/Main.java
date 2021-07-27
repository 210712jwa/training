package game;

public class Main {

	public static void main(String[] args) {
		
		PlayerSingleton ps1 = PlayerSingleton.getInstance();
		PlayerSingleton ps2 = PlayerSingleton.getInstance();

		System.out.println("ps1 == ps2: " + (ps1 == ps2)); // true because both reference variables are pointing to the same object
		// This is essentially guaranteed through the Singleton design pattern
	}

}
