package com.revature;

import java.util.Queue;

public class Consumer extends Thread {

	private Queue<Integer> buffer;
	
	public Consumer(Queue<Integer> buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				synchronized(buffer) {
					while (buffer.isEmpty()) {
						System.out.println("Consumer " + super.getName() + " is falling asleep!");
						buffer.wait();
					}
					
					int value = buffer.remove();
					
					System.out.println("Consuming value: " + value);
					
					buffer.notifyAll(); // notifies to producers (technically consumers as well) that are asleep to wake back up.
					// Producers can now potentially produce values because the queue is no longer full
					
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
