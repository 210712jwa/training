package com.revature.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {

	public static void demo() {		
		// Maps are structured as key-value pairs
		// You can retrieve a value based on a key
		// This retrieval occurs in O(1) time (constant time)
		// So, this is extremely useful for various different lookup purposes
		
		// Two implementations
		// HashMap: not thread safe (kind of like StringBuilder) (HashMap also allows one null key, and multiple null values)
		// HashTable: is thread safe (kind of like StringBuffer) (HashTable doesn't allow a null key or null values)
		// TreeMap: the keys are naturally ordered whenever we iterate over the elements and print them out
		Map<String, Long> phoneBook = new HashMap<>();
		
		phoneBook.put("Mom", 1111111111L);
		phoneBook.put("Dad", 2222222222L);
		phoneBook.put(null, 4444444444L);
		
		// duplicate keys are not possible (should be pretty obvious)
		// so if I do .put("Mom", <value>) again, it will overwrite the original value
		phoneBook.put("Mom", 3333333333L);
		System.out.println(phoneBook.get("Mom"));
		
		System.out.println(phoneBook.get(null));
		
		// Iterating over keys
		Set<String> phoneBookKeys = phoneBook.keySet();
		for (String key : phoneBookKeys) {
			System.out.println(key);
		}
		
		// Iterating over keys and values
		Set<Entry<String, Long>> keyValuePairs = phoneBook.entrySet();
		
		for (Entry<String, Long> keyValuePair : keyValuePairs) {
			System.out.println("key = " + keyValuePair.getKey() + " : value = " + keyValuePair.getValue());
		}
		
		// Iterating over just the values
		Collection<Long> values = phoneBook.values();
		
		for (long value : values) {
			System.out.println(value);
		}
		
		// Important distinction between Map and all of the other Collections (Set, Queue, List) is that
		// Map is NOT part of the Collection hierarchy
		// IT IS A COLLECTION, but not part of this inheritance structure
		// Reason being, a Map is not an Iterable
		// So, I cannot use an enhanced for loop with a Map
	}
	
}
