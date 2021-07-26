package com.revature;

import java.util.HashSet;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

	public static void main(String[] args) {
		
		final int BUFFER_SIZE = 100;
		final int NUM_OF_PRODUCERS = 4;
		final int NUM_OF_CONSUMERS = 4;
		
		Queue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE); // This Queue has a max size of 'BUFFER_SIZE'
		
		// populate our buffer w/ random integer values until it is half full
		for (int i = 0; i < BUFFER_SIZE / 2; i++) {
			buffer.add((new Random()).nextInt(50));
		}
		
		/*
		 * Create producers
		 */
		Set<Producer> producers = new HashSet<>();
		
		for (int i = 0; i < NUM_OF_PRODUCERS; i++) {
			producers.add(new Producer(buffer));
		}
		
		/*
		 * Create consumers
		 */
		Set<Consumer> consumers = new HashSet<>();
		
		for (int i = 0; i < NUM_OF_CONSUMERS; i++) {
			consumers.add(new Consumer(buffer));
		}
		
		/*
		 * Start up threads
		 */
		for (Producer p : producers) {
			p.start();
		}
		
		for (Consumer c : consumers) {
			c.start();
		}

	}

}
