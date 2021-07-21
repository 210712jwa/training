package com.revature.model;

public class Circle extends Shape {

	private double radius;
	
	public Circle(double radius) {
		super("Circle");
		this.radius = radius;
		
		calculateArea();
	}

	@Override
	public void calculateArea() {
		double area = this.radius * this.radius * Drawable.PI;
		super.area = area;
	}
	
}
