package com.revature.abstraction;


/*
 * abstraction is the process of hiding some details and only showing essential
 * 
 * this is achieved with abstract classes and interfaces (these cannot be instantiated)
 */
public class Driver {

	public static void main(String[] args) {
		
		//animal is the reference type
		Animal a1 = new Cat();
		
		//you can assign the variable to any object that extends animal
		a1 = new Frog();
	}

}
