package com.revature;

// <E> is the idea of generics
// Generics can be referred to as "parameterized" types
// This allows us to generalize what type of data we want, the return types for our methods, the parameter types for our methods, etc.
// It is a way of enforcing "type-safety"
// This means that we can ensure that the type we have specified originally is the type that we will always be interacting with.
public class Node<E> {

	private E data;
	
	private Node<E> next;
	
	public Node(E data) {
		this.data = data;
	}
	
	public E getData() {
		return this.data;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
	public Node<E> getNext() {
		return this.next;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Node [ data = " + this.data + " ]";
	}
}
