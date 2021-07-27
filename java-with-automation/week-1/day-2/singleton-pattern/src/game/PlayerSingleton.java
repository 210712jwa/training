package game;

// We want to have this class utilize the Singleton design pattern
// This means that we should ensure that this class ever has only 1 instance
// And this 1 instance should be able to be accessed from anywhere
public class PlayerSingleton {

	// I have a static reference variable to point to the single instance of PlayerSingleton
	private static PlayerSingleton instance;
	
	private String currentRoom;
	
	// We restrict access to the constructor so that it is not possible to arbitrarily construct new instances of this class
	private PlayerSingleton() {
		super();
	}
	
	// This method allows us to access the single instance of this class
	// It should check whether instance is null, and if it is, construct the object for the first time
	// From then on, if we call this method again, it should always return us that same object
	public static PlayerSingleton getInstance() {
		if (instance == null) {
			PlayerSingleton.instance = new PlayerSingleton();
		}
		
		return PlayerSingleton.instance;
	}
	
	/*
	 * Getters / Setters
	 * 
	 * hashCode, equals, toString
	 */

	public String getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(String currentRoom) {
		this.currentRoom = currentRoom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentRoom == null) ? 0 : currentRoom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerSingleton other = (PlayerSingleton) obj;
		if (currentRoom == null) {
			if (other.currentRoom != null)
				return false;
		} else if (!currentRoom.equals(other.currentRoom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlayerSingleton [currentRoom=" + currentRoom + "]";
	}
	
}
