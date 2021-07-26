package com.revature;

public class Demo {

	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		Thread[] threads = new Thread[100];
		
		Runnable r = () -> {
			for (int i = 0; i < 100; i++) {
				counter.increment();
			}
		};
		// Each thread should run the above code that calls the increment method on the counter object 100 times
		
		// After this for loop is done executing, all of the Thread objects are in the NEW state
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(r);
		}
		
		// After this for loop is done executing, all of the Thread objects will be in the RUNNABLE state
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		// Tell the main thread to wait for all of these other threads to finish executing first before moving onto subsequent lines of code
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// Print out the value of the value property belonging to the counter object
		// This should only be done when the 100 threads we created have completed processing.
		System.out.println(counter.getValue()); // We would expect 10,000 (except we don't because of race conditions)

	}

}
