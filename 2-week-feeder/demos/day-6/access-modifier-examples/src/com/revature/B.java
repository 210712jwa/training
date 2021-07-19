package com.revature;

public class B {

	public static void main(String[] args) {
		System.out.println(A.a); // public, so it works
		System.out.println(A.b); // protected, so it works
		System.out.println(A.c); // default, so it works
		// System.out.println(A.d); // private, so this doesn't work
		// we are not inside the same class as the d static variable.
		
		A obj1 = new A(100, -153, 0, 10);
		System.out.println(obj1.w); // public
		System.out.println(obj1.x); // protected
		System.out.println(obj1.y); // default
		// System.out.println(obj1.z); // private
	}
	
}
