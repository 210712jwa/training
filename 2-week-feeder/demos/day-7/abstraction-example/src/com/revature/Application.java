package com.revature;

import com.revature.model.CalculableArea;
import com.revature.model.Circle;
import com.revature.model.Drawable;
import com.revature.model.Rectangle;
import com.revature.model.Shape;
import com.revature.model.Triangle;

public class Application {

	public static void main(String[] args) {
		Shape shape = new Rectangle(10.7, 10);
		System.out.println(shape);

		shape = new Circle(3);
		System.out.println(shape);
		
		shape = new Triangle(10, 5);
		System.out.println(shape);
		
		// Whenever we create a class or an interface
		// We create a Type of the same name as that class or interface
		// So if we have an abstract class called Shape, we have a type called Shape
		// if we have a concrete class called Rectangle, we have a type called Rectangle
		// If we have an interface called Drawable, we have a type called Drawable
				
		Drawable d;
		d = new Rectangle(10, 5);
		d.draw();
		System.out.println(d);
		
		System.out.println(((Shape) d).getShapeName());
		
		CalculableArea ca = (CalculableArea) d;
		System.out.println(ca.getArea());
		System.out.println(ca);
	}

}
