package com.revature;

import com.revature.model.Person;

public class Application {

	public static void main(String[] args) {
		
		Person person = new Person("Billy12", 23, "000-000-0000");
		
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getPhoneNumber());
		
		person.setAge(90);
		System.out.println(person.getAge());
		
		person.setName("Michael12 @$O'leary#");
		System.out.println(person.getName());
		
		person.setPhoneNumber("111-111-1111");
		System.out.println(person.getPhoneNumber());
	}

}
