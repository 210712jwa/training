package com.revature;

public class Node {

	private int number; // by default this is 0, but it's going to be set anyways using the constructor
	
	private Node next; // by default this is null
	
	public Node(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Node [ number = " + this.number + " ]";
	}
	
}
