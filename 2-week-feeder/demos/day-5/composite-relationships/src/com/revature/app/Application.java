package com.revature.app;

import com.revature.model.Car;
import com.revature.model.Engine;

public class Application {

	public static void main(String[] args) {
		Engine engine = new Engine("Inline", 6, 320, 280);
		Car car = new Car("Toyota", "Supra", engine);

	}

}
