package com.revature;

public class Stack<E> {
	
	private int length;
	
	private Node<E> top;
	
	public void push(E element) {
		Node<E> node = new Node<>(element);
		push(node);
	}
	// method overloading, we can have one of the methods call the other as well
	private void push(Node<E> node) {
		node.setNext(top);
		top = node;
		length++;
	}
	
	public E pop() {
		if (length == 0) throw new NoElementException();
		
		Node<E> poppedElement = top; // get the current top element to pop off
		top = top.getNext(); // set the new top element to be the second to the top
		poppedElement.setNext(null); // for the popped element, set the next reference to null
		length--;
		return poppedElement.getData(); // return the popped element
	}
	
	public E peek() {
		if (length == 0) throw new NoElementException();
		
		return top.getData();
	}
	
	public int length() {
		return this.length;
	}
	
}
