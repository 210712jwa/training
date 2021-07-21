package com.revature;

// A functional interface is pretty much like any other interface
// Except for it must contain only a single abstract method
// It can contain as many static methods as it wants
@FunctionalInterface
public interface FunctionalInterfaceExample {

	boolean test(String s); // public abstract void ourFunction() <- public abstract is added automatically (implicitly)
	
}
