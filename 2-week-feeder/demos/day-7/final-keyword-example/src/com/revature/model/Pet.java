package com.revature.model;

public abstract class Pet {
	
	protected String name;
	
	// example of final being used for parameters
	public Pet(final String name) {
		// name = "asdf"; // Can't do this
		this.name = name;
	}
	
	// If I don't want child classes to be able to override this method, then I can make it final
	public final String getName() {
		return this.name;
	}
	
}
