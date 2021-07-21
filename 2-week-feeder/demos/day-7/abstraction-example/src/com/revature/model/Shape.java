package com.revature.model;

public abstract class Shape implements Drawable, CalculableArea { // Shape is inheriting directly from the Object class

	protected String shapeName;
	protected double area;
	
	// Abstract classes CANNOT be instantiated
	// But they can have constructors
	// Because the child class will have a super(...) call to the parent class constructor
	// Which would be this constructor here
	public Shape(String shapeName) {
		this.shapeName = shapeName;
	}
	
	// Because we are implementing the CalculableArea interface, which requires us to implement an abstract method
	// calculateArea(), we don't need to define it here. Instead it just gets inherited and then passed along to our concrete
	// classes for them to do the implementation
//	public abstract void calculateArea();
	// It does not have a method body. It is just an abstract idea for what a concrete Shape should be doing
	
	// abstract classes CAN contain concrete methods
	@Override
	public double getArea() {
		return this.area;
	}
	
	public String getShapeName() {
		return this.shapeName;
	}
	
	@Override
	public String toString() {
		return this.shapeName + " has an area of " + this.area;
	}
	
	// Originally, when I first had the Shape class here implement the Drawable interface, it broke my Rectangle, Circle, and Triangle
	// Classes
	// That is because the Drawable interface requires us to provide an implementation of the draw() method
	// Because the Shape class here is an abstract method, it can just pass along that responsibility to the concrete classes
	// Rectangle, Circle, and Triangle
	// However, in our case, we decided to provide a concrete implementation of draw() directly inside of this abstract Shape class
	// Therefore, we don't need to provide 3 different implementations in each of the subclasses of the Shape class
	// Because as soon as we encounter the very first concrete method going down the inheritance chain, we already have a 
	// well defined behavior available to us
	@Override
	public void draw() {
		System.out.println("Drawing a " + this.shapeName + "....");
	}
	
}
