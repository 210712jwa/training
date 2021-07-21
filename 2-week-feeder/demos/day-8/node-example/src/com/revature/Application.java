package com.revature;

import java.util.LinkedList;

public class Application {

	public static void main(String[] args) {
		Node firstNode = new Node(100);
		Node secondNode = new Node(1000);
		Node thirdNode = new Node(543);
		
		firstNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		
		System.out.println(firstNode.getNext().getNext().getNumber());
		
		int[] ints = new int[3];
		ints[0] = 100;
		ints[1] = 1000;
		ints[2] = 543;
		
		LinkedList<Integer> ll = new LinkedList<>();
	}

}
