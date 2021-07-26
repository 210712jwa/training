package com.revature;

public class MyClass extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 1000; i++) {
			System.out.println(Thread.currentThread().getName() + ": instruction #" + i);
		}
	}
	
}
