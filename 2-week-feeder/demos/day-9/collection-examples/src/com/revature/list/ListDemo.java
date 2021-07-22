package com.revature.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

	public static void demo() {
		
		// Lists maintain order of elements. We can access elements by an index
		// The order of elements is determined by the order that I add those elements.
		
		// ArrayLists are the typical go-to when working with a List. You should use LinkedLists only if you see a real
		// performance benefit for some niche use-case
		List<String> list = new ArrayList<>(); // the ArrayList class implements the List interface
		// Therefore an ArrayList is a List, so I can use the List type to point to an ArrayList
		
		// I could also have my List reference variable point to a LinkedList
		// list = new LinkedList<>();
		
		list.add("Peaches"); // 0th element
		list.add("Avocadoes"); // 1st element
		list.add("Apples"); // 2nd element
		list.add("Plums"); // 3rd element
		list.add("Oranges"); // 4th element
		list.add("Kiwis"); // 5th element
		list.add("Kiwis"); // 6th element
		list.add("Kiwis"); // 7th element
		list.add("Kiwis"); // 8th element
		list.add("Mangoes"); // 9th element
		
		System.out.println("List: " + list);
		System.out.println("How many elements are inside the list: " + list.size());
		
		list.add(1, "Pears"); // O(n)
		System.out.println("List: " + list);
		
		// accessing an element by index
		System.out.println(list.get(2));
		
		// removing an element by index
		list.remove(2);
		System.out.println(list);
		
		list.remove(new String("Kiwis")); // remove the first occurrence of the String kiwis
		// behind the scenes, the remove method makes use of the .equals() method, and if .equals() returns true, then it removes 
		// that element
		System.out.println(list);
		
		// traversing a list
		for (int i = 0; i < list.size(); i++) {
			System.out.println("index: " + i + ": " + list.get(i));
			
			// let's try removing all occurences of kiwis
			if (list.get(i).equals("Kiwis")) {
				list.remove(i); // if we remove an element, we end up shifting all of the elements in the list
				i--; // so even though we want to actually remove all occurences of kiwis, we could actually be skipping over
				// some of them
				// so i-- after removing an element allows us to continue on like normal
			}
		}
		
		System.out.println(list);
		
		// Enhanced for loop (aka for each loop)
		// Behind the scenes, the enhanced for loop is making use of an Iterator to iterate over the elements
		System.out.println("========================");
		// You can use enhanced for loops with Iterables (anything that implements the Iterable interface)
		// OR
		// Arrays
		
		// A List is an Iterable, so we can use an enhanced for loop with it
		for (String i : list) {
			System.out.println(i);
		}
		
		list.add("Kiwis");
		list.add("Kiwis");
		list.add("Kiwis");
		
		Iterator<String> iter = list.iterator(); // the iterator() method which is required to be implemented by the Iterable interface
		// returns an Iterator object
		
		// This object can be used to traverse through our list
		// Here's how:
		System.out.println("========================");
		while (iter.hasNext()) {
			System.out.println(iter.next()); // the next() method of the Iterator object returns the next element in our list
		}
		// Once the iterator object has iterated through all of the elements, it is pretty much done being used
		// We can't reuse it again to go through the elements another time
		
		iter = list.iterator(); // This will set the iter reference variable to a new Iterator object
		// If we want to remove all of the Kiwis Strings, we can do that with an iterator
		while (iter.hasNext()) {
			if (iter.next().equals("Kiwis")) {
				iter.remove(); // this removes the last element returned by .next()
				// then we can just keep going onto the next element
			}
		}
		
		System.out.println(list);
		
		// contains(E element) returns a boolean of true if the element exists
		System.out.println("Does list contain Apples? " + (list.contains(new String("Apples")) ? "yes" : "no"));
		
		// indexOf(E element) returns the index of the first element encountered that equals the value passed in
		System.out.println("index of 'Pears' inside our list: " + (list.indexOf("Pears")));
		System.out.println("index of 'Bananas' inside out list: " + (list.indexOf("Bananas"))); // -1, because element was not found
		
		// Collection v. Collections
		// Collection: it's the interface that our various different collections implement
		// Collections: it's a class that contains utility methods (static) that we can use
		// A utility class is a class that is not used as a blueprint for objects, but instead contains static methods that might be
		// useful for us to use
		
		// For example, Arrays is a utility class, Collections is a utility class as well
		System.out.println("====================");
		// Collection class examples:
		System.out.println(list);
		Collections.reverse(list); // reverses the order of our elements (back goes to front)
		System.out.println(list);
		
		Collections.sort(list); // This will sort our Strings alphabetically
		// How does know how to do that?
		// There is a concept of natural ordering that is established through the Comparable interface or Comparator interface
		System.out.println(list);
	}

	// Here my method can make use of ANY list
	// That's one of the reasons to use the List interface as a type for the parameter instead of 
	// ArrayList or LinkedList
	// This is so that we have more flexibility over what type of list we can accept
	public static void doSomethingWithAStringList(List<String> list) {
		
	}
	
}
