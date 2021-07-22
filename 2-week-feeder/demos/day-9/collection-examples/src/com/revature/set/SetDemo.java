package com.revature.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.revature.model.Car;

public class SetDemo {

	public static void demo() {
		// implementations of the Set interface:
		// 1. HashSet: no "guaranteed" ordering
		// 2. TreeSet: ordered elements via natural ordering
		Set<String> set = new HashSet<>();
		
		set.add("Peaches");
		set.add("Avocadoes");
		set.add("Apples");
		set.add("Plums");
		set.add("Oranges");
		set.add("Kiwis");
		
		System.out.println(set);
		
		System.out.println(set.add(new String("Kiwis"))); // A set contains only non-duplicate elements
		// So if I add another String with the value of Kiwis, then it will not be added
		System.out.println(set);
		// So how does the add method determine that two elements are duplicates?
		// .equals(Object o)
		
		Set<Car> cars = new HashSet<>();
		cars.add(new Car(2021, "Toyota", "Supra"));
		cars.add(new Car(2021, "Toyota", "Supra"));
		System.out.println(cars);
		
		System.out.println(cars.contains(new Car(2021, "Toyota", "Supra")));
		
		cars.add(new Car(2022, "Ford", "Mustang GT"));
		
		// Because Sets, Lists, Queues are extending the Collection interface, which extends the Iterable interface,
		// Sets are Iterables
		// This means I can use an enhanced for loop to iterate over all elements
		for (Car c : cars) {
			System.out.println(c);
		}
		
		/*
		 * Using a TreeSet instead of HashSet
		 * 
		 * TreeSets have an order according the natural ordering of elements
		 * 
		 * If we remember about our Car example, we had the Car class implement the Comparable interface
		 * This interface requires that we implement the compareTo method, which will provide a natural ordering
		 * for Car objects
		 * 
		 * The natural ordering of Cars is by the year, in our example
		 * 
		 * So when we add cars to a TreeSet, and iterate over the elements, we will see the earlier years printed out first
		 * followed by the later years
		 */
		Set<Car> orderedCars = new TreeSet<>();
		orderedCars.add(new Car(1994, "Toyota", "Supra"));
		orderedCars.add(new Car(2002, "Lexus", "LS 430"));
		orderedCars.add(new Car(2002, "BMW", "330i"));
		orderedCars.add(new Car(1997, "Honda", "Accord"));
		
		System.out.println();
		
		for (Car c : orderedCars) {
			System.out.println(c);
		}
	}
	
}
