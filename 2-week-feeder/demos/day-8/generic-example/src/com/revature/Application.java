package com.revature;

public class Application {

	public static void main(String[] args) {
		
		// We are passing in "Integer" as a parameter for our types in the class
		// Notice that when we hover over the constructor, it now says that the constructor only accepts a Integer type
		Node<Integer> intNode1 = new Node<>(10);
		Node<Integer> intNode2 = new Node<>(20);
		
		// But if we hover over the constructor for the following line, it only accepts a Double type
		Node<Double> doubleNode1 = new Node<>(20.5);
		Node<Double> doubleNode2 = new Node<>(10.232);
		
		// the setNext method accepts a type of Node<Integer> in this example
		intNode1.setNext(intNode2);
		
		// the setNext method here accepts a the Node<Double>
		doubleNode1.setNext(doubleNode2);
		
		// So we can clearly see how the types of parameters accepted by the methods inside of the Node class change according
		// to what parameter type we pass in for our generic (e.g. Node<Integer> v. Node<Double>)
		
		System.out.println(intNode1.getNext().getData());
		System.out.println(doubleNode1.getNext().getData());
		
		/*
		 * Making use of our stack
		 */
		Stack<String> stackOfStrings = new Stack<>();
		stackOfStrings.push("first string");
		stackOfStrings.push("second string");
		stackOfStrings.push("third string");
		System.out.println(stackOfStrings.length());
		stackOfStrings.push("fourth string");
		
		System.out.println(stackOfStrings.peek());
		
		System.out.println(stackOfStrings.pop()); // pop off 'fourth string'
		System.out.println(stackOfStrings.pop()); // pop off 'third string'
		System.out.println(stackOfStrings.pop()); // pop off 'second string'
		
		System.out.println(stackOfStrings.length());
		
		System.out.println(stackOfStrings.pop()); // pop off 'first string'
//		System.out.println(stackOfStrings.peek());
	}

}
