package com.revature;

// Without using the synchronized keyword, our Counter class here is considered "non thread-safe"
// This means that multiple threads can access the methods here at the same time
// Which could lead to unpredictable results with the value property
// Due to race conditions potentially being an issue
public class Counter {

	private int value;
	
	private Object lock = new Object(); // Any Object in Java can serve as a lock / "our hotel room"
	
	public Counter() {
		super();
	}
	
	// If we wanted our incrementation of the value property to be 100% predictable and consistent even with multi-threading in our
	// application, we need to restrict access to the increment method to one thread at a time.
	// This means that we should make this method have to be fully completed by a particular thread before another thread can enter
	// this code
	
	// When you use synchronized within the method signature itself, the "hotel room" that we're using is the object instance itself
	// This means that if you have a thread that is accessing the increment method, any other methods that might be using synchronized
	// in the method signature would also be inaccessible by other threads. Because the object instance itself is already occupied
	public /*synchronized*/ void increment() {
		
		synchronized (lock) {
			this.value = this.value + 1;
		}
		
	}
	
	public int getValue() {
		return this.value;
	}

}

// When it comes to using the synchronized keyword, we're making use of locks
// Think of a Hotel as an analogy
// Only a single customer can be occupying any one hotel room at a time
// So when a customer checks in, they will receive a key to the lock so that they can access the room
// If another customer wants the same room, they need to wait for the other customer to return the key (checking-out)
// before they can receive the key themselves and enter
