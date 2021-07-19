package com.revature;

public class A {
	
	// instance fields
	public int w;
	protected int x;
	int y; // default
	private int z;
	
	// static fields
	public static int a;
	protected static int b;
	static int c;
	private static int d;
	
	// If you declare fields and don't assign a value, they have
	// what are known as "default values"
	// numbers are 0 or 0.0
	// booleans are false
	// reference variables are null
	
	public A(int w, int x, int y, int z) {
		this.w = w;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static void main(String[] args) {
		A obj1 = new A(10, 150, 22, -1000);
		
		// w, x, y, and z are instance fields
		System.out.println(obj1.w);
		System.out.println(obj1.x);
		System.out.println(obj1.y);
		System.out.println(obj1.z);
		
		// a, b, c, and d are static fields
		// We can access them directly from the class itself
		System.out.println(A.a);
		System.out.println(A.b);
		System.out.println(A.c);
		System.out.println(A.d);
	}
}
