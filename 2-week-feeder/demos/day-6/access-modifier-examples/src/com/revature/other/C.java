package com.revature.other;

import com.revature.A;

public class C extends A {

	public C(int w, int x, int y, int z) {
		super(w, x, y, z);
	}
	
	public static void main(String[] args) {
		System.out.println(A.a); // public
		System.out.println(A.b); // protected, doesn't work unless we make C a subclass of A
		// System.out.println(A.c); // does not work because we're in a different package from class A
		// System.out.println(A.d); // private
		
		C cObj = new C(-1000, -2000, 100, 200);
		System.out.println(cObj.w); // public
		System.out.println(cObj.x); // protected
		// System.out.println(obj.y); // default
		// System.out.println(obj.z); // private
		
		A aObj = new A(100, 200, -100, 200);
		System.out.println(aObj.w); // public
		// System.out.println(aObj.x); // protected, but can't access because the protected accessibility rule
		// for instance properties is based on the object's type and not the context of the code
	}
	
}
