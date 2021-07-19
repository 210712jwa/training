package com.revature;

public class Application {

	public static void main(String[] args) {
		// 0, 1, 1, 2, 3, 5, 8, 13, 21
		long startTime = System.nanoTime();
		System.out.println(getNthFibRecursive(48));
		long endTime = System.nanoTime();
		
		System.out.println("Recursive time: " + (endTime - startTime));
		
		long startTime2 = System.nanoTime();
		System.out.println(getNthFibInPlace(48));
		long endTime2 = System.nanoTime();
		
		System.out.println("Recursive time: " + (endTime2 - startTime2));
		
		System.out.println("The in place algorithm was " + (endTime - startTime)/(endTime2 - startTime2) + "x faster");
		
		// The recursive algorithm has a big O time of O(2^n)
		// The in-place algorithm has a big O time of O(n)
		
	}

	// This algorithm is not really ideal because it's considered "slow"
	// A way to gauge how good an algorithm is, is through Big O notation
	// Given some sort of input, we want to see how many operations are required as we scale up that input
	// In this case, as the int n parameter increases in value, the operations required grows incredibly large, very fast
	public static long getNthFibRecursive(int n) {
		if (n == 1) return 0;
		if (n == 2) return 1;
		
		return getNthFibRecursive(n - 1) + getNthFibRecursive(n - 2);
		// operations = 2*2^n = 2^n
		// therefore, the recursive algorithm is O(2^n)
	}
	
	public static long getNthFibInPlace(int n) {
		long[] arr = new long[n];
		arr[0] = 0;
		arr[1] = 1;
		
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		return arr[arr.length - 1];
	}
	// operations = 3 + 1*(n - 2) + 1 = 3 + n - 2 + 1 = 2 + n = n
	// Therefore, the in place algorithm is O(n)
	
}
