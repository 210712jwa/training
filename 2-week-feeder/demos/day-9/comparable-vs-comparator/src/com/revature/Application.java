package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		Person p1 = new Person("William", 10);
		Person p2 = new Person("Robert", 1);
		Person p3 = new Person("Alex", 10);

		List<Person> people = new ArrayList<>();
		people.add(p1);
		people.add(p2);
		people.add(p3);
		
		System.out.println(people); // The order of the elements in this ArrayList is based on when they were added to the List
		
		// But, we can use the sort method inside of the Collections utility class in order to sort them by their natural ordering
		Collections.sort(people);
		
		System.out.println(people);
		
		// Comparable v. Comparator
		// Comparable is an interface that you implement on the objects that you want to have a natural ordering for
		// BUT, sometimes we want to have custom sorting logic instead of the natural ordering
		// In these cases, we would use what are known as Comparators
		
		// sort according to a Comparator object
		Collections.sort(people, new ReverseAgeThenReverseNameComparator()); // sort by this Comparator instead of the natural ordering
		System.out.println(people);
	}

}
