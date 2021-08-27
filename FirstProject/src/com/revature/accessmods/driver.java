package com.revature.accessmods;

/*
 * 4 pillars of OOP
 * -abstraction
 * -polymorphism
 * -inheritance
 * -encapsulation
 * 
 * encapsulation is a mechanism by which data and methods can be
 * wrapped together in a single unit
 */

public class driver {

	public int pubField = 1; //visible to whole project
	/*static*/ protected int procField = 2; //visible in same package and all child classes
	int defaultField = 3; //(default) visible in same package
	private int privField; //only visible within class
	
	public static void main(String[] args) {

		driver d1 = new driver();
		
		//no problem accessing these fields
		//System.out.print(procField); //this could be done if procField is static

	}

}
