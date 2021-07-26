package com.revature;

public class Example {

	Object lock1 = new Object();
	Object lock2 = new Object();
	
	/*
	 * Deadlock: This situation arises if we have two threads in which 1 thread is depending on another lock in order to release the lock
	 * it currently has, but the other thread is also depending on the lock of the first thread in order to release its lock
	 * Therefore, both threads are stuck and can't continue
	 */
	
	public void method1() {
		synchronized (lock1)  {
			
			System.out.println("Waiting for lock2...");
			synchronized(lock2) {
				
			}
		}
	}
	
	public void method2() {
		synchronized (lock2) {
			
			System.out.println("Waiting for lock1...");
			synchronized(lock1) {
				
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Example e = new Example();
		
		Runnable r1 = () -> e.method1();
		Runnable r2 = () -> e.method2();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		Thread.sleep(1000);
		System.out.println(t1.getState().toString());
		System.out.println(t2.getState().toString());
	}
	
}
