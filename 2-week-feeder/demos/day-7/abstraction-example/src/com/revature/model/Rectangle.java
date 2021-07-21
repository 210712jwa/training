package com.revature.model;

public class Rectangle extends Shape {

	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		super("Rectangle");
		this.length = length;
		this.width = width;
		
		calculateArea();
	}
	
	// When we provide an implementation for an abstract method, it is also considered overriding
	// When we extend from an abstract class, WE MUST provide a concrete implementation of any abstract methods
	// defined in that AC
	@Override
	public void calculateArea() {
		double area = this.length * this.width;
		super.area = area;
	}
	
}
