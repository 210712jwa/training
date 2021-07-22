package com.revature;

import java.util.Comparator;

public class ReverseAgeThenReverseNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if (o1.getAge() == o2.getAge()) {
			return -1 * o1.getName().compareTo(o2.getName());
		}
		
		return -1 * (o1.getAge() - o2.getAge());
		
		// 0 if equal
		// < 0 if o1 comes before o2
		// > 0 if o1 comes after o2
	}

}
