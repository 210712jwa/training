package com.revature;

public class MyArrayList<E> {

	private E[] arr;
	private int currentNumOfElements = 0;
	private int capacity = 0;
	
	public MyArrayList(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Invalid capacity specified");
		}
		
		this.capacity = capacity;
		arr = (E[]) new Object[capacity];
	}
	
	public MyArrayList() {
		this(8); // if a user utilizes this no-args constructor (meaning they're not providing their own capacity)
		// We will just initialize the MyArrayList with a capacity of 8
	}
	
	public int size() {
		return this.currentNumOfElements;
	}
	
	public boolean isEmpty() {
		return this.currentNumOfElements == 0;
	}
	
	public E get(int index) {
		if (index < 0 || index > currentNumOfElements - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		return arr[index];
	}
	
	public void set(int index, E element) {
		if (index < 0 || index > currentNumOfElements - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		arr[index] = element;
	}
	
	public void clear() {
		for (int i = 0; i < capacity; i++) {
			arr[i] = null;
		}
		
		this.currentNumOfElements = 0;
	}
	
	public void add(E elem) {
		// If our array is full, create a new array that is double the size, copy the elements from the original array to the new one
		// And then set the new array to be our current array
		if (this.currentNumOfElements + 1 >= capacity) {
			capacity = capacity * 2;
			
			E[] newArray = (E[]) new Object[capacity];
			for (int i = 0; i < currentNumOfElements; i++) {
				newArray[i] = arr[i];
			}
			
			this.arr = newArray;
		}
		
		arr[currentNumOfElements] = elem;
		currentNumOfElements++;
	}
	
	@Override
	public String toString() {
		if (currentNumOfElements == 0) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			
			for (int i = 0; i < currentNumOfElements - 1; i++) {
				sb.append(arr[i] + ", ");
			}
			
			sb.append(arr[currentNumOfElements - 1] + "]");
			
			return sb.toString();
		}
	}
}
