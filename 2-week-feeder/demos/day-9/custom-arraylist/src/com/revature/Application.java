package com.revature;

public class Application {

	public static void main(String[] args) {
		MyArrayList<String> myArrayList = new MyArrayList<>();
		
		myArrayList.add("Test1");
		myArrayList.add("Test2");
		myArrayList.add("Test3");
		myArrayList.add("Test4");
		myArrayList.add("Test5");
		myArrayList.add("Test6");
		myArrayList.add("Test7");
		myArrayList.add("Test8");
		myArrayList.add("Test9");

		System.out.println(myArrayList);
		
		System.out.println(myArrayList.size());
		myArrayList.clear();
		System.out.println(myArrayList);
	}

}
