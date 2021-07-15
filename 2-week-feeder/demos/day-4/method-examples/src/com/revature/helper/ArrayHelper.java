package com.revature.helper;

public class ArrayHelper {

	/**
	 * Returns the elements that the array is composed of, in the correct ordering
	 * 
	 * @param intArr which is an int array
	 * @return String representing the elements in the array
	 */
	public static String toString(int[] intArr) {
		if (intArr.length == 0) return "[]";
		
		String elements = "[";
		
		for (int i = 0; i < intArr.length - 1; i++) {
			elements += (intArr[i] + ", ");
		}
		
		elements += intArr[intArr.length - 1] + "]";
		
		return elements;
	}
	
}
