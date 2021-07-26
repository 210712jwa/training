package com.revature;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {

	private Queue<Integer> buffer;
	
	public Producer(Queue<Integer> buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				synchronized (buffer) {
					int x = (new Random()).nextInt(50);
					
					while (!buffer.offer(x)) { // If the thread failed to add a value to the queue because of the queue being full,
						// have the thread fall asleep
						System.out.println("Producer " + super.getName() + " is falling asleep!");
						buffer.wait(); // the wait() method will have the thread that is currently occupying buffer, release its lock on buffer
						// for other threads to be able to enter.
					}
					
					// We break out of the while loop if we successfully added a value to queue
					System.out.println("Added a value: " + x);
					buffer.notifyAll(); // "I have produced a value, any Threads that are in WAITING, please return back to being RUNNABLE"
					
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
}
