package com.revature.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.revature.model.Car;

public class QueueDemo {

	public static void demo() {
		
		Queue<String> linkedListQueue = new LinkedList<>();
		
		linkedListQueue.add("1st Person");
		linkedListQueue.add("2nd Person");
		linkedListQueue.add("3rd Person");
		
		System.out.println(linkedListQueue.remove()); // 1st Person in line is the first person out
		System.out.println(linkedListQueue.remove());
		System.out.println(linkedListQueue.remove());
		
		// This implementation of Queue (PriorityQueue) works differently than the LinkedList implementation
		// Some elements can skip the line based on the natural ordering of the elements
		// For Strings, this is enforced via the compareTo method that is implemented from the Comparable interface
		// And basically it is alphabetical
		Queue<String> priorityQueue = new PriorityQueue<>();
		priorityQueue.add("b");
		priorityQueue.add("c");
		priorityQueue.add("a"); // a gets the skip the line, because a has priority over b and c
		
		while(!priorityQueue.isEmpty()) {
			System.out.println(priorityQueue.remove());
		}
		
		Queue<Car> priorityQueue2 = new PriorityQueue<>();
		priorityQueue2.add(new Car(2015, "BMW", "3 Series"));
		priorityQueue2.add(new Car(2020, "Kia", "Stinger GT"));
		priorityQueue2.add(new Car(1994, "Toyota", "Supra"));
		
		while(!priorityQueue2.isEmpty()) {
			System.out.println(priorityQueue2.remove());
		}
	}
	
}
