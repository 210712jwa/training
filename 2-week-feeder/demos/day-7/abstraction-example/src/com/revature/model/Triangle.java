package com.revature.model;

public class Triangle extends Shape {

	private double base;
	private double height;
	
	public Triangle(double base, double height) {
		super("Triangle");
		this.base = base;
		this.height = height;
		
		calculateArea();
	}
	
	@Override
	public void calculateArea() {
		super.area = (0.5) * base * height;
	}
	
}
