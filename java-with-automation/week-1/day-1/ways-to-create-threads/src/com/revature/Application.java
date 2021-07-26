package com.revature;

public class Application {

	public static void main(String[] args) {
		// Whenever I run my application, it is single threaded, by default (to begin with)
		// I can see the name of this thread by doing
		System.out.println(Thread.currentThread().getName()); // currentThread() is a static method found in the Thread class
		// that returns to us the reference to the thread that just executed this method.

		// The name of the main thread of our program is main. This is the initial thread that is spun up when we execute our program.
		// From this main thread, we could create other threads, and have them run concurrently with our main thread
		
		// Traditionally, there were 2 ways of creating and running threads in Java
		
		// #1: We can create a class that extends the Thread class and then override the run() method
		Thread t = new MyClass();
		t.start();
				
		// #2: This is the preferred way of creating new threads. We can implement the Runnable interface and then provide an implementation
		// for the run method defined in the interface. We can then create a new Thread object, passing in this Runnable into the constructor
		// Then call .start() on our Thread object
		Runnable r = new MyClassTwo();
		Thread t2 = new Thread(r);
		t2.start();
		
		for (int i = 1; i <= 1000; i++) {
			System.out.println(Thread.currentThread().getName() + ": instruction #" + i);
		}
		
		// Any interface that has only a single abstract method is called a functional interface
		// Runnable has only a single abstract method, public abstract void run(). Therefore it is a functional interface
		// Because of this fact, I can use lambda expressions when defining a Runnable implementation instead of having to create
		// a brand new class, then using implements Runnable
		
		// Instead of creating an entire class such as MyClassTwo in the above example, I can just do this lambda expression:
		Runnable r2 = () -> {
			for (int i = 1; i <= 1000; i++) {
				System.out.println(Thread.currentThread().getName() + ": instruction #" + i);
			}
		};
		// The above lambda expression is a really convenient way of writing code that you want a new Thread to be executing when
		// it is started up
		
		Thread t3 = new Thread(r2);
		t3.start();
		
		// We could also just do this
		Thread t4 = new Thread(() -> {
			for (int i = 1; i <= 1000; i++) {
				System.out.println(Thread.currentThread().getName() + ": instruction #" + i);
			}
		});
		t4.start();
	}

}
