package com.revature.scanner;

import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
		
		// an object is a reusable component within our code
		
		//classes are object blueprints
		
		Scanner scan = new Scanner(System.in); //the new keyword instantiates an object of the invoked class
		
		//prompt for name entry
		System.out.print("please enter name: ");
		
		//capture name
		String name = scan.nextLine();
		
		//prompt for age
		System.out.print("please enter age: ");
		
		//capture age
		int age = scan.nextInt();
		
		//print name back out and age in 100 years
		System.out.print("Hello " + name + ".\n In 100 years, you will be " + getFutureAge(age) + " years old.");
		
	}
	
	/**
	 * public is an access modifier that means this can be accessed anywhere in the application
	 * 
	 * static means that you don't need to instantiate this class in order to call the method
	 * @param age
	 * @return
	 */
public static int getFutureAge(int age) {
	return (age + 100);
}

}
