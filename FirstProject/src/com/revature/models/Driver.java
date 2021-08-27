package com.revature.models;

public class Driver {

	public static void main(String[] args) {
		// can you instantiate an object from a class that you haven't defined a constructor for?
		//a reference type is a "custom type" ( a user defined class)
		Person p1 = new Person("Fred", 30, 64, 160.56);
		
		System.out.println(p1);
		
		System.out.println(p1.getAge());
		System.out.println(p1.getHeight());
		
		System.out.println(p1.toString());
		
		//you can set the max age variable here, but not if it is final (DO MORE RESEARCH)
		
		System.out.println("Fred's BMI is " + p1.calculateBMI(p1.getHeight(), p1.getWeight()));
		
		//below, two seperate objects are being instantiated
		Employee s1 = new Employee("bob", 2, 3, 4, "Fins");
		Employee s2 = new Employee("bob", 2, 3, 4, "Fins");
		
		//are they equal?
		System.out.println(s1.equals(s2));
		//not unless you override the equals (now the case)
		
		System.out.println(s1 == s2); //this is false (they are still different objects)
	}

}
