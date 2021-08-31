package com.revature.main;

import com.revature.model.Car;

public class Main {

	public static void main(String[] args) {
		
		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Camry");
		car.setYear(2010);
		
		System.out.println(car);
		
		Car car2 = new Car("Toyota", "Camry", 2010);
		
		System.out.println("car == car2: " + (car == car2));
		
		System.out.println("car.equals(car2): " + (car.equals(car2)));

	}

}
